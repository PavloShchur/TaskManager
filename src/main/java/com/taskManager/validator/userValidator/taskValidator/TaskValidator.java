package com.taskManager.validator.userValidator.taskValidator;

import com.taskManager.dao.TaskDao;
import com.taskManager.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by User on 01.06.2017.
 */

@Component
public class TaskValidator implements Validator {

    @Autowired
    TaskDao taskDao;
    @Override
    public void validate(Object o) throws Exception {


    }
}
