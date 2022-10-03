package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.services.ProductServices;


@Controller
@RequestMapping("/admin/")
public class AdminHomeController {

	@RequestMapping("/")
	public String index() {
		
		return "admin-template/index";
			
	}

	@RequestMapping("manager_product")
	public String ManagerProduct() {
		
		return "admin-template/pages/forms/form_manager_product";
			
	}
}
