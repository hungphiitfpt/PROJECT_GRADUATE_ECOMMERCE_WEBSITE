package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.model.ColorEntity;
import com.poly.edu.project.graduation.model.SizeEntity;
import com.poly.edu.project.graduation.services.ColorServices;
import com.poly.edu.project.graduation.services.SizeServices;

@RestController
@RequestMapping("/api/graduation/")
public class SizeRestController {
	
	@Autowired
	SizeServices sizeservices;
	
	@GetMapping("size/getAllSize")
	public List<SizeEntity> getAllColor() {
		
		return sizeservices.findAll();
		
	}

}
