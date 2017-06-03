package com.taskManager.service;

import com.taskManager.entity.Task;

import java.util.List;

public interface TaskService {

    void save(Task task) throws Exception;

    List<Task> findAll();

    Task findOne(int id);

    void delete(int id);

    void update(Task task);
}
