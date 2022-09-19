package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.model.CategoryEntity;
import com.poly.edu.project.graduation.services.CategoryServices;

@RestController
@RequestMapping("/api/graduation/")
public class CategoryRestController {

	@Autowired
	CategoryServices categoryServices;
	
	@GetMapping("category/getAllCategory")
	public List<CategoryEntity> getAllCategory() {
		
		return categoryServices.findAll();
		
	}
	
}
