package com.poly.edu.project.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KHANHCONTROLLER {

	@RequestMapping("/shop")
	
	public String index() {

		return "template/shop";

	}
}