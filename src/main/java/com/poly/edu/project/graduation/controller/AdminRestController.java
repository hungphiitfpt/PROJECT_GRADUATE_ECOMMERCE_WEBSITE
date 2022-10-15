package com.poly.edu.project.graduation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	// api thêm sản phẩm, kiểm tra nếu đã có sản phẩm trùng trên không được thêm
	@RequestMapping(value = "/insert_product", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
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

	@RequestMapping(value = "/update/product", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity<ResponseObject> updateProduct(@RequestBody ShopProductsEntity newProduct, @Param("id") Long id) {
		Optional<ShopProductsEntity> updatedProduct = productsRepository.findById(id).map(product -> {
			product.setCategoryId(newProduct.getCategoryId());
			product.setCreatedAt(newProduct.getCreatedAt());
			product.setDecription(newProduct.getDecription());
			product.setDeleted(newProduct.isDeleted());
			product.setDiscountinued(newProduct.getDiscountinued());
			product.setFeatured(newProduct.isFeatured());
			product.setImage(newProduct.getImage());
			product.setListPrice(newProduct.getListPrice());
			product.setProductCode(newProduct.getProductCode());
			product.setProductName(newProduct.getProductName());
			product.setQuantityPerUnit(newProduct.getQuantityPerUnit());
			return productsRepository.save(product);
		});
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Update Product successfully", updatedProduct));
	}

	@RequestMapping(value = "/update/isdeleted", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateIsDeleted(@Param("id") long id) {
		productServices.changeStatusIsdeleted(id);
	}
	
	@RequestMapping(value = "/update/in_stock", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateInstock(@Param("id") long id) {
		productServices.changeStatusInstock(id);
	}

}
