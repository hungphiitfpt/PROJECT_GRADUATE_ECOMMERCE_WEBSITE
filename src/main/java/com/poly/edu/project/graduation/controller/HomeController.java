//package com.poly.edu.project.graduation.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.poly.edu.project.graduation.services.CategoryServices;
//import com.poly.edu.project.graduation.services.ProductServices;
//
//@Controller
//public class HomeController {
//	@Autowired
//	ProductServices productServices;
//
//	@Autowired
//	CategoryServices categoryServices;
//
////	@Autowired
////	ColorServices colorServices;
//	
//	@GetMapping("/")
//	public String Home(@RequestParam(name = "page", defaultValue = "0") int page,
//			@RequestParam(name = "size", defaultValue = "9") int size, 
//			@ModelAttribute("category") String category,
//			@ModelAttribute("name") String name, 
//			@ModelAttribute("sizeProduct") String sizeProduct,
//			@ModelAttribute("color") String color, 
//			@ModelAttribute("price") String price, Model model) {
//
//		model.addAttribute("products",productServices.findAllBy(category, name, sizeProduct, color, price, PageRequest.of(page, size)));
//		model.addAttribute("categories", categoryServices.findAll());
//		model.addAttribute("productsSaleOff", productServices.findAllProductSaleOff());
////		model.addAttribute("colors", colorServices.findAll());
//
//
//		return "product/ogani-master/index";
//
//	}
//
//}