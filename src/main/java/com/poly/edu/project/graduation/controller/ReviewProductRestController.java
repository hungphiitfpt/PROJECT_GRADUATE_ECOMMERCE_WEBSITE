package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ReviewProductRepository;
import com.poly.edu.project.graduation.model.MonthDTO;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.ReviewProductService;

@RestController
@RequestMapping("/api/graduation")
public class ReviewProductRestController {

	@Autowired
	ReviewProductService reviewProductService;
	
	@Autowired
	ReviewProductRepository productRepository;

	@RequestMapping(value = "/getAllReviewById", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ShopProductReviewsEntity> getProductById(
			@RequestParam(name = "id", required = false, defaultValue = "") Long id) {

		List<ShopProductReviewsEntity> reviewProduct = reviewProductService.findAllReviewProduct(id);

		return reviewProduct;

	}
	

	@RequestMapping(value = "/TESTABC", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<String> GETSS() {

		List<String> reviewProduct = productRepository.getTotalPrice();
		
	
		return reviewProduct;

	}
	
	@RequestMapping(value = "/ok", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String test() {

		String reviewProduct = productRepository.updatelist();
		
	
		return reviewProduct;

	}

}
