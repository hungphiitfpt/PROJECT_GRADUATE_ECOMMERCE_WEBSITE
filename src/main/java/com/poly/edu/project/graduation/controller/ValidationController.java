package com.poly.edu.project.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationController {

	@RequestMapping("validation")
	public String index() {
		
		return "validationTemplate";
		
	}
}
