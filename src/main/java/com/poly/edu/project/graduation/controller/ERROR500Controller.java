package com.poly.edu.project.graduation.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ERROR500Controller {

	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String index() {
		
		return "admin-template/pages/samples/error-500";
		
	}
}
