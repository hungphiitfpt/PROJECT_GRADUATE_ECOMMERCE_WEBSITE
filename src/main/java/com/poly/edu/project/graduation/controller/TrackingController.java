package com.poly.edu.project.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrackingController {

	@RequestMapping("tracking-order")
	public String index() {
		return "shop-template/tracking-order";
		
	}
}
