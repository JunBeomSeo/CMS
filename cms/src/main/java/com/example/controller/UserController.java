package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {

	
	@GetMapping("/signupPage")
	public String signupPage() {
		return "user/signup";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
