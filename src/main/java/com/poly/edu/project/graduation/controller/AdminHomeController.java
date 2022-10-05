package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.ProductServices;

@Controller

public class AdminHomeController {

	@Autowired
	ProductServices productServices;
	
	@Autowired
	ProductsRepository productsRepository;

	@RequestMapping("/")
	public String index() {
		
		return "admin-template/index";

	}

	@RequestMapping("manager_product")
	public String ManagerProduct() {

		return "admin-template/pages/forms/form_manager_product";

	}

}
