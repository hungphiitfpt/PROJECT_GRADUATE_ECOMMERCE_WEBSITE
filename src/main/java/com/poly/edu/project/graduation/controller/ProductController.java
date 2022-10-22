
package com.poly.edu.project.graduation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ReviewProductRepository;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.CategoryServices;
import com.poly.edu.project.graduation.services.ProductServices;
import com.poly.edu.project.graduation.services.ReviewProductService;

@Controller
public class ProductController {

	@Autowired
	ProductServices productServices;

	@Autowired
	CategoryServices categoryServices;

	@Autowired
	ReviewProductService reviewProductService;

//	@RequestMapping("/shop")
//	public String index(Model model, HttpServletRequest request,
//			@ModelAttribute(name = "idCategory") String idCategory,
//			@RequestParam(name = "size", required = false, defaultValue = "12") int size,
//			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
//			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
//
//		try {
//
//			Page<ShopProductsEntity> listProduct = productServices.findAllProducts(idCategory,
//					PageRequest.of(page, size));
//			List<ShopCategoriesEntity> listCategory = categoryServices.findAll();
//			model.addAttribute("category", listCategory);
//			model.addAttribute("product", listProduct);
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return "template/shop";
//
//	}

	@RequestMapping("/index")
	public String index() {
		return "shop-template/index";

	}

	@RequestMapping("/shop")
	public String shop(Model model, HttpServletRequest request, @ModelAttribute(name = "idCategory") String idCategory,
			@RequestParam(name = "size", required = false, defaultValue = "12") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

		try {
			Page<ShopProductsEntity> listProduct;
			listProduct = productServices.findAllProducts(idCategory, PageRequest.of(page, size));
			List<ShopCategoriesEntity> listCategory = categoryServices.findAll();
			model.addAttribute("category", listCategory);
			model.addAttribute("product", listProduct);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "shop-template/shop";

	}

//	@RequestMapping("/getProductByCategoryid/{idCategory}")
//	public String getProductByCategoryid(Model model, @PathVariable Long idCategory) {
//
//		List<ShopCategoriesEntity> listCategory = categoryServices.findAll();
//		model.addAttribute("category", listCategory);
//
//		List<ShopProductsEntity> product = productServices.findAllProductByCategoryId(idCategory);
//		model.addAttribute("product", product);
//
//		return "template/shop";
//
//	}
// 
	
	@RequestMapping("/getProductByid/{id}")
	public String getProductById(Model model, @PathVariable Long id) {

		ShopProductsEntity product = productServices.findProductById(id);

//		List<ShopProductReviewsEntity> reviewProduct = reviewProductService.findAllReviewProduct(id);

//		System.out.println(reviewProduct);

		model.addAttribute("product", product);
		System.out.println(product);

		model.addAttribute("images", product.getShopProductImagesById());

		model.addAttribute("review", product.getShopProductReviewsById());

		return "shop-template/product-details";

	}

}