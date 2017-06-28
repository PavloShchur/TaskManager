package com.taskManager.controller;

import com.taskManager.editors.TaskEditor;
import com.taskManager.entity.Task;
import com.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

	@Autowired
	private TaskService taskService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Task.class, new TaskEditor());
	}

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("tasks", taskService.findAll());
		return "base/home";
	}

	@PostMapping("/home")
	public String anton() {
		return "redirect:/";
	}

	@RequestMapping("/loginpage")
	public String login() {
		return "base/loginpage";
	}

	@PostMapping("/logout")
	public String logout() {

		return "redirect:/";
	}

}
