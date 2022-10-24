package com.poly.edu.project.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

	@RequestMapping("order-page")
	public String index() {
		
		return "shop-template/shop-cart";
		
	}
}
