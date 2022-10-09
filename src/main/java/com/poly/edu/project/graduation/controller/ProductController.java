
package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/shop")
	public String index(Model model) {

		try {
			List<ShopProductsEntity> listProduct = productServices.findAllProducts();

			List<ShopCategoriesEntity> listCategory = categoryServices.findAll();

			model.addAttribute("category", listCategory);
			model.addAttribute("product", listProduct);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "template/shop";

	}

	@RequestMapping("/getProductByCategoryid/{idCategory}")
	public String getProductByCategoryid(Model model, @PathVariable Long idCategory) {

		List<ShopCategoriesEntity> listCategory = categoryServices.findAll();
		model.addAttribute("category", listCategory);

		List<ShopProductsEntity> product = productServices.findAllProductByCategoryId(idCategory);
		model.addAttribute("product", product);

		return "template/shop";

	}
 
	@RequestMapping("/getProductByid/{id}")
	public String getProductById(Model model, @PathVariable Long id) {

		ShopProductsEntity product = productServices.findProductById(id);

		List<ShopProductReviewsEntity> reviewProduct = reviewProductService.findAllReviewProduct(id);
		
		System.out.println(reviewProduct);

		model.addAttribute("product", product);

		model.addAttribute("images", product.getShopProductImagesById());

		model.addAttribute("review", product.getShopProductReviewsById());

		return "template/product-single";

	}


}