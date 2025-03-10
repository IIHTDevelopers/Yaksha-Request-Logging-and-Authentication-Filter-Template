package com.yaksha.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	// This is a simple user registration page
	@GetMapping("/user/register")
	public String showRegistrationPage(Model model) {
		model.addAttribute("message", "Please fill in the registration details!");
		return "user-registration";
	}

	// This endpoint will be protected by the filter (authentication check)
	@GetMapping("/user/dashboard")
	public String userDashboard(Model model) {
		model.addAttribute("message", "Welcome to your dashboard!");
		return "user-dashboard";
	}
}
