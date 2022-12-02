package com.poly.edu.project.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegisterController {
	
	@RequestMapping("register")
	public String index() {
		
		return "admin-template/pages/samples/register";
		
	}
}
