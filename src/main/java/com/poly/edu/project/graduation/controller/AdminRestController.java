package com.poly.edu.project.graduation.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.ProductServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	@Autowired
	ProductServices productServices;
	@Autowired
	ProductsRepository productsRepository;

	// api thêm sản phẩm, kiểm tra nếu đã có sản phẩm trùng trên không được thêm
	@RequestMapping(value = "/insert_product", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	ResponseEntity<ResponseObject> insertProduct(@RequestBody ShopProductsEntity shopProductsEntity) {
		List<ShopProductsEntity> foundProducts = productServices
				.findByProductName(shopProductsEntity.getProductName().trim());
		if (foundProducts.size() > 0) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("failed", "Đã có sản phẩm trùng tên ", ""));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("200", "Thêm Thành Công ", productsRepository.save(shopProductsEntity)));
	}
	
	// api lấy tất cả sản phẩm
	@RequestMapping(value = "/getAllProductTableManager", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopProductsEntity> getAllProductTableManager(
			@RequestParam(name = "keyword", required = false, defaultValue = "")  String keyword,
			@RequestParam(name = "size", required = false, defaultValue = "10")  int size,
			@RequestParam(name = "page", required = false, defaultValue = "0")  int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
		
		return productServices.findByKeyWord(keyword, PageRequest.of(page, size));

	}
}
