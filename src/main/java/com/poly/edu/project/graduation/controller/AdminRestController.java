package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.ProductServices;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	@Autowired
	ProductServices productServices;
	@Autowired
	ProductsRepository productsRepository;

	/*
	 * API cập nhật sản phẩm
	 */
	@RequestMapping(value = "/update_product", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional(rollbackFor = {Exception.class, Throwable.class})
	ResponseEntity<ResponseObject> insertProduct(@RequestBody ShopProductsEntity newProduct, @Param("id") Long id)
			throws Exception {
		ShopProductsEntity updatedProduct = productsRepository.findById(id).map(product -> {
			product.setCategoryId(newProduct.getCategoryId());
			product.setDiscountinued(newProduct.getDiscountinued());
			product.setDecription(newProduct.getDecription());
			product.setImage(newProduct.getImage());
			product.setListPrice(newProduct.getListPrice());
			product.setProductCode(newProduct.getProductCode());
			product.setProductName(newProduct.getProductName());
			product.setQuantityPerUnit(newProduct.getQuantityPerUnit());
			product.setShortDecription(newProduct.getShortDecription());
			product.setStandCost(newProduct.getStandCost());
			return productsRepository.save(product);
		}).orElseGet(() -> {
			newProduct.setId(0);
			return productsRepository.save(newProduct);
		});
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Update Product successfully", updatedProduct));
	}

	/*
	 *  api thêm sản phẩm, kiểm tra nếu đã có sản phẩm trùng trên không được thêm
	 */
	@RequestMapping(value = "/insert_product", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional(rollbackFor = {Exception.class, Throwable.class})
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

	/*
	 *  api chỉnh sửa  trạng thái của sản phẩm hết hàng
	 */
	@RequestMapping(value = "/update/isdeleted", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateIsDeleted(@Param("id") long id) {
		productServices.changeStatusIsdeleted(id);
	}

	/*
	 *  api chỉnh sửa  trạng thái của sản phẩm còn hàng
	 */
	@RequestMapping(value = "/update/in_stock", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateInstock(@Param("id") long id) {
		productServices.changeStatusInstock(id);
	}

}
