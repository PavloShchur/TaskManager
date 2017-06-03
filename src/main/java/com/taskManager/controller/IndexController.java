//package com.taskManager.controller;
//
//import com.taskManager.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class IndexController {
//
//	@Autowired
//	UserService userService;
//
//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("users", userService.findAll());
//		return "views-base-index";
//	}
//