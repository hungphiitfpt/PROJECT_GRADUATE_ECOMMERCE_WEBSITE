package com.poly.edu.project.graduation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.services.ProductServices;

@Controller

public class AdminHomeController {

	@Autowired
	ProductServices productServices;
	
	@Autowired
	ProductsRepository productsRepository;

	@RequestMapping("/index2")
	public String index() {
		
		return "admin-template/index";

	}
	

	@RequestMapping("manager_product")
	public String ManagerProduct() {
		
		return "admin-template/pages/forms/form_manager_product";

	}
	
	@RequestMapping("manager_employee")
	public String ManagerEmployee() {

		return "admin-template/pages/forms/form_manager_employee";

	}
	
	@RequestMapping("manager_category")
	public String ManagerCategory() {

		return "admin-template/pages/forms/form_manager_cagegory";

	}
	


}
