package com.taskManager.editors;

import com.taskManager.entity.Task;
import com.taskManager.service.TaskService;

import java.beans.PropertyEditorSupport;

public class TaskEditor extends PropertyEditorSupport {

    private final TaskService taskService;


    public TaskEditor(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Task task = new Task();
        task.setId(Integer.parseInt(text));

        setValue(task);
    }
}


