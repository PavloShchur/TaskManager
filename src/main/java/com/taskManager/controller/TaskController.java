package com.taskManager.controller;

import com.taskManager.entity.Task;
import com.taskManager.entity.User;
import com.taskManager.service.MailSenderService;
import com.taskManager.service.TaskService;
import com.taskManager.service.UserService;
import com.taskManager.validator.userValidator.taskValidator.TaskValidationMessages;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Transactional
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    private Task tasks = new Task();

    @GetMapping("/listOfTasks")
    public String task(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        List<Task> tasks = taskService.findAll();
        for (Task task : tasks) {
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
                    e.getMessage().equals(TaskValidationMessages.TITLE_ALREADY_EXISTS)) {
                model.addAttribute("TaskTitleException", e.getMessage());
            }
            return "views-admin-listOfTasks";
        }
        return "redirect:/listOfTasks";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/listOfTasks";
    }

    @GetMapping("/updateTask/{id}/{userId}")
    public String getTask(@PathVariable int id, @PathVariable int userId, Model model) {
        model.addAttribute("user", taskService.findTaskWithUser(userId));
        model.addAttribute("taskAttribute", taskService.findOne(id));
        return "admin/updateTask";
    }

    @PostMapping("/updateTask/{id}")
    public String updateUser(@ModelAttribute("task") Task task, @PathVariable int id, Model model) {
        List<Task> tasks = taskService.findAll();
        for (Task task1 : tasks) {
            Hibernate.initialize(task1.getUsers());
        }
        task.setId(id);
        taskService.update(task);
        model.addAttribute("tasks", taskService.findAll());
        return "redirect:/listOfTasks";
    }

    @GetMapping("/updateTaskWithoutUser/{id}")
    public String getTaskWithoutUser(@PathVariable int id, Model model) {
        model.addAttribute("taskAttribute", taskService.findOne(id));
        return "admin/updateTaskWithoutUser";
    }

    @PostMapping("/updateTaskWithoutUser/{id}")
    public String getTaskWithoutUser(@ModelAttribute("task") Task task, @PathVariable int id, Model model) {
        List<Task> tasks = taskService.findAll();
        for (Task task1 : tasks) {
            Hibernate.initialize(task1.getUsers());
        }
        task.setId(id);
        taskService.update(task);
        model.addAttribute("tasks", taskService.findAll());
        return "redirect:/listOfTasks";
    }

    @GetMapping("/addTaskToUser/{id}")
    public String addTaskToUser(@PathVariable int id, Model model) {
        List<Task> tasks = taskService.findAll();
        for (Task task : tasks) {
            Hibernate.initialize(task.getUsers());
        }
        model.addAttribute("userAttribute", userService.findOne(id));
        model.addAttribute("tasks", taskService.findAll());
        return "user/addTaskToUser";
    }

    @PostMapping("/addTaskToUser/{id}")
    public String userConfirmTask(@RequestParam String name, @RequestParam String email,
                                  @RequestParam String password, @RequestParam int taskID,
                                  @PathVariable int id) {
        User user = new User(name, email, password);
        user.setId(id);
        user.setTask(taskService.findOne(taskID));
        userService.update(user);
        tasks = user.getTask();
        System.out.println("user.getTask(): " + user.getTask());
        System.out.println("TASKS: " + tasks);
        String theme = "Thank You";
        String mailBody = "gl & hf  http://localhost:8080/submitTask/" + user.getId();
        mailSenderService.sendMail(theme, mailBody,
                user.getEmail());
        System.out.println(mailBody);

        return "redirect:/registration";
    }

    @GetMapping("/submitTask/{id}")
    public String submitTask(@PathVariable int id, Model model) {
        model.addAttribute("userConfirmTask", tasks);
        model.addAttribute("userAttribute", userService.findOne(id));
        return "user/submitTask";
    }

    @PostMapping("/submitTask/{id}")
    public String submitTaskAfter(@PathVariable int id) {
        User user = userService.findOne(id);
        user.setTask(tasks);
        userService.update(user);
        System.out.println("user.getTask(): " + user.getTask());

        return "redirect:/registration";
    }
}
