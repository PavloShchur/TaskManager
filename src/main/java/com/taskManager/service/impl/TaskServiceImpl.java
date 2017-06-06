package com.taskManager.service.impl;

import com.taskManager.dao.TaskDao;
import com.taskManager.entity.Task;
import com.taskManager.entity.User;
import com.taskManager.service.TaskService;
import com.taskManager.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Task findTaskWithUser(int id) {
         return taskDao.findTaskWithUser(id);
    }

    @Autowired
    @Qualifier("taskValidator")
    Validator validator;

    @Override
    public void save(Task task) throws Exception {
        validator.validate(task);
        taskDao.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

    @Override
    public Task findOne(int id) {
        return taskDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        taskDao.delete(id);
    }

    @Override
    public void update(Task task) {
        taskDao.save(task);

    }
}
