package com.poly.edu.project.graduation.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/getAllProductTableManager", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ShopProductsEntity> getAllProductTableManager() {
		
		return productServices.getAllProductTableManager();

	}
}
