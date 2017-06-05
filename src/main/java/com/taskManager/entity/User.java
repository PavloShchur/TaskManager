package com.taskManager.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = "task")
@Builder
public class User extends AbstractEntity implements UserDetails {
//
//    {
//        Builder builder = User.builder().name("rthy").email("bgfnhm").password("fvbgh").role()
//    }

    private String name;
    private String email;
    private String password;

    @Enumerated
    private Role role = Role.ROLE_USER;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    private Task task;


//    public User(String name, String email, String password) {
//        super();
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return name;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}


