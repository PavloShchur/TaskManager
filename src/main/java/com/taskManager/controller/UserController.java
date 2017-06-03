package com.taskManager.controller;

import com.taskManager.editors.TaskEditor;
import com.taskManager.entity.Task;
import com.taskManager.entity.User;
import com.taskManager.service.TaskService;
import com.taskManager.service.UserService;
import com.taskManager.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@InitBinder
	public void init(WebDataBinder binder){
		binder.registerCustomEditor(Task.class, new TaskEditor(taskService));
	}

	@GetMapping("/registration")
	public String user(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("user", new User());
		return "user/registration";
	}

	@Autowired
	PasswordEncoder passwordEncoder;
	@PostMapping("/saveUser")
	public String user(@ModelAttribute User user, Model model) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.save(user);
		} catch (Exception e) {
			if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
					e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXISTS)){
				model.addAttribute("UserNameException", e.getMessage());
			}
			return "views-user-registration";
		}
		return "redirect:/";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("users", userService.findAll());
		return "signup";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {

		userService.delete(id);

		return "redirect:/registration";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable int id, Model model) {
		model.addAttribute("userAttribute", userService.findOne(id));
		return "views-user-updateUser";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user, @PathVariable int id, Model model) {
		user.setId(id);
		userService.update(user);
		model.addAttribute("users", userService.findAll());
		return "views-user-registration";
	}



}