package com.poly.edu.project.graduation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.CategoryServices;
import com.poly.edu.project.graduation.services.ProductServices;

@Controller
public class KHANHCONTROLLER {
	@Autowired
	ProductServices productServices;
	
	@Autowired
	CategoryServices categoryServices;
	

	
	@RequestMapping("/shop")
	public String index(Model model) {
		List<ShopCategoriesEntity> listCategory = categoryServices.findAll();
		model.addAttribute("category", listCategory);
		return "template/shop";

	}
	
	@RequestMapping("/getProductByCategoryid/{idCategory}")
	public String getProductByCategoryid(Model model, @PathVariable Long idCategory) {
		
		List<ShopCategoriesEntity> listCategory = categoryServices.findAll();
		model.addAttribute("category", listCategory);
		
		List<ShopProductsEntity> product = productServices.findAllProductById(idCategory);
		model.addAttribute("product", product);
		
		
		
		return "template/shop";

	}
	
	
}
