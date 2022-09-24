
package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.edu.project.graduation.model.ProductsEntity;
import com.poly.edu.project.graduation.services.CategoryServices;
import com.poly.edu.project.graduation.services.ColorServices;
import com.poly.edu.project.graduation.services.ProductServices;
import com.poly.edu.project.graduation.services.SizeServices;

@Controller
public class ProductController {

	@Autowired
	ProductServices productServices;

	@Autowired
	CategoryServices categoryServices;

	@Autowired
	ColorServices colorServices;

	
	//gọi danh sách sp
	@RequestMapping("product/shop-grid")
	public String list(Model model) {
		List <ProductsEntity> list=productServices.findAllProducts();
		model.addAttribute("items",list);
		return "product/shop-grid";
	}
	
	//gọi chi tiết sp
	@RequestMapping("product/ogani-master/shop-details/{id}")
		public String detail(Model model, @PathVariable("id") Integer id) {
			ProductsEntity item= productServices.findProductById(id);
			model.addAttribute("item",item);
			return "product/ogani-master/shop-details";
		}
	
	
	@GetMapping("productShop")
	public String viewProductShop(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "9") int size, 
			@ModelAttribute("category") String category,
			@ModelAttribute("name") String name, 
			@ModelAttribute("sizeProduct") String sizeProduct,
			@ModelAttribute("color") String color, 
			@ModelAttribute("price") String price, Model model) {

		model.addAttribute("products",productServices.findAllBy(category, name, sizeProduct, color, price, PageRequest.of(page, size)));
		model.addAttribute("categories", categoryServices.findAll());
		model.addAttribute("productsSaleOff", productServices.findAllProductSaleOff());
		model.addAttribute("colors", colorServices.findAll());


		return "product/ogani-master/shop-grid";

	}


}