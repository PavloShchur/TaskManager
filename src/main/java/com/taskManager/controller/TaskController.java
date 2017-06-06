package com.taskManager.controller;

import com.taskManager.entity.Task;
import com.taskManager.service.TaskService;
import com.taskManager.service.UserService;
import com.taskManager.validator.userValidator.taskValidator.TaskValidationMessages;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@Transactional
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/listOfTasks")
    public String task(Model model, Principal principal) {
        model.addAttribute("tasks", taskService.findAll());
        List<Task> tasks = taskService.findAll();
        for(Task task: tasks) {
            Hibernate.initialize(task.getUsers());
        }
        model.addAttribute("task", new Task());
        return "admin/listOfTasks";
    }

    @PostMapping("/saveTask")
    public String task(@ModelAttribute Task task, Model model) {
        try {
            taskService.save(task);
        } catch (Exception e) {
            if (e.getMessage().equals(TaskValidationMessages.EMPTY_TITLE_FIELD) ||
                    e.getMessage().equals(TaskValidationMessages.TITLE_ALREADY_EXISTS)){
                model.addAttribute("TaskTitleException", e.getMessage());
            }
            return "views-admin-listOfTasks";
        }
        return "redirect:/listOfTasks";
    }

    @GetMapping ("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.delete(id);

        return "redirect:/listOfTasks";
    }

    @GetMapping("/updateTask/{id}")
    public String getTask(@PathVariable int id, Model model) {
        model.addAttribute("taskAttribute", taskService.findOne(id));
        return "admin/updateTask";
    }

    @PostMapping("/updateTask/{id}")
    public String updateUser(@ModelAttribute("task") Task task, @PathVariable int id, Model model) {
        task.setId(id);
        taskService.update(task);
        model.addAttribute("tasks", taskService.findAll());
        return "admin/listOfTasks";
    }
}
