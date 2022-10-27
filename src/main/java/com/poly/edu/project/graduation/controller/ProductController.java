
package com.poly.edu.project.graduation.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.edu.project.graduation.model.CartEntity;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
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

	/*
	 * View trang chủ index
	 */
	@RequestMapping("/index")
	public String index() {
		return "shop-template/index";

	}

	/*
	 * Trả về view của trang sản phẩm
	 */
	@RequestMapping("/shop")
	public String shop(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute(name = "idCategory") String idCategory,
			@RequestParam(name = "size", required = false, defaultValue = "12") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

		try {
			Map<Long, CartEntity> cartItems = (Map<Long, CartEntity>) session
					.getAttribute("cart");
			Page<ShopProductsEntity> listProduct;
			listProduct = productServices.findAllProducts(idCategory, PageRequest.of(page, size));
			List<ShopCategoriesEntity> listCategory = categoryServices.findAll();
			model.addAttribute("category", listCategory);
			model.addAttribute("product", listProduct);
			model.addAttribute("cartStarts", Utils.cartStarts(cartItems));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "shop-template/shop";

	}


	@RequestMapping("/getProductByid/{id}")
	public String getProductById(Model model, @PathVariable Long id) {

		ShopProductsEntity product = productServices.findProductById(id);


		model.addAttribute("product", product);

		model.addAttribute("images", product.getShopProductImagesById());

		model.addAttribute("review", product.getShopProductReviewsById());

		return "shop-template/product-details";

	}

}