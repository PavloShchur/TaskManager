package com.taskManager.service.impl;

import com.taskManager.dao.UserDao;
import com.taskManager.entity.Task;
import com.taskManager.entity.User;
import com.taskManager.service.UserService;
import com.taskManager.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("userValidator")
    Validator validator;

    public void save(User user) throws Exception {
        validator.validate(user);
        userDao.save(user);

    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return userDao.findAll();

    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }

    public void delete(int id) {
        userDao.delete(id);

    }

    public void update(User user) {
        userDao.save(user);
    }

//    @Override
//    public User findUserByTask(int id) {
//        return userDao.findUserByTask(id);
//    }

    @Override
    public void addTaskToUser(User user, Task task) {
        user.setTask(task);
        userDao.save(user);

//        book.setGenre(genre);
//        bookDao.save(book);
    }

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.findByName(name);
    }
}
