//package com.poly.edu.project.graduation.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.poly.edu.project.graduation.model.CategoryEntity;
//import com.poly.edu.project.graduation.model.ColorEntity;
//import com.poly.edu.project.graduation.services.CategoryServices;
//import com.poly.edu.project.graduation.services.ColorServices;
//
//
//@RestController
//@RequestMapping("/api/graduation/")
//public class ColorRestController {
//
//	@Autowired
//	ColorServices colorServices;
//	
//	@GetMapping("color/getAllColor")
//	public List<ColorEntity> getAllColor() {
//		
//		return colorServices.findAll();
//		
//	}
//	
//	
//}
