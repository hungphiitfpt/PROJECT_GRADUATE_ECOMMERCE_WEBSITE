package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.edu.project.graduation.services.ProductServices;

@Controller
public class HomeController {

	@Autowired
	ProductServices productServices;
	@GetMapping("/")
	public String home() {
		
		
		return "product/ogani-master/index";
		
	}

}