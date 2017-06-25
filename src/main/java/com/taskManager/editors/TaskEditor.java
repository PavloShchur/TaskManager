package com.taskManager.editors;

import com.taskManager.entity.Task;

import java.beans.PropertyEditorSupport;

public class TaskEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Task task = new Task();
        task.setId(Integer.parseInt(text));

        setValue(task);
    }
}


