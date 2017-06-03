package com.taskManager.validator.userValidator;

import com.taskManager.dao.UserDao;
import com.taskManager.entity.User;
import com.taskManager.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by User on 29.05.2017.
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {
        User user = (User) o;

        if (user.getName().isEmpty()) {
            throw new UserException(UserValidationMessages.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByName(user.getName()) != null) {
            throw new UserException(UserValidationMessages.USERNAME_ALREADY_EXISTS);
        }
    }
}
