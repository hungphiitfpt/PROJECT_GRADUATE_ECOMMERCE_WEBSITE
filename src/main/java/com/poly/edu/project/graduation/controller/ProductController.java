
package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.edu.project.graduation.services.CategoryServices;
import com.poly.edu.project.graduation.services.ColorServices;
import com.poly.edu.project.graduation.services.ProductServices;

@Controller
public class ProductController {

	@Autowired
	ProductServices productServices;

	@Autowired
	CategoryServices categoryServices;

	@Autowired
	ColorServices colorServices;

	@GetMapping("productShop")
	public String viewProductShop(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "9") int size, @RequestParam("category") String category,
			@RequestParam("name") String name, @RequestParam("sizeProduct") String sizeProduct,
			@RequestParam("color") String color, @RequestParam("price") String price, Model model) {

		model.addAttribute("products",
				productServices.findAllBy(category, name, sizeProduct, color, price, PageRequest.of(page, size)));
		model.addAttribute("categories", categoryServices.findAll());
		model.addAttribute("productsSaleOff", productServices.findAllProductSaleOff());
		model.addAttribute("colors", colorServices.findAll());

		return "product/ogani-master/shop-grid";

	}

}