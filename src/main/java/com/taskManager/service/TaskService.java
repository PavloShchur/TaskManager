package com.taskManager.service;

import com.taskManager.entity.Task;
import com.taskManager.entity.User;

import java.util.List;

public interface TaskService {

    void save(Task task) throws Exception;

    List<Task> findAll();

    Task findOne(int id);

    void delete(int id);

    void update(Task task);

    Task findTaskWithUser(int id);

}
