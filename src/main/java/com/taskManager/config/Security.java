package com.taskManager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.taskManager")
public class Security extends WebSecurityConfigurerAdapter{

    @Qualifier("userDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryUserDetailsManagerConfigurer(){
        return new InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationProvider provider) throws Exception {
        inMemoryUserDetailsManagerConfigurer()
                .withUser("adm")
                .password("adm")
                .authorities("ADMIN")
                .and()
                .configure(auth);
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/loginpage")
                .passwordParameter("password")
                .usernameParameter("username")
                .loginProcessingUrl("/loginprocesing")
                .and()
                .csrf();
    }
}