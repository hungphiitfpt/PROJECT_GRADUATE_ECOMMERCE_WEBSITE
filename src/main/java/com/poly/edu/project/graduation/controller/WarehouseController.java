package com.poly.edu.project.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class WarehouseController {

	@RequestMapping("/getPageWarehouse")
	public String index() {
		return "admin-template/pages/forms/form_create_warehouse";
	}
}
