package com.poly.edu.project.graduation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.model.ShopWarehouseEntity;
import com.poly.edu.project.graduation.services.WarehouseService;

@RestController
@RequestMapping("/api/admin")
public class WarehouseRestController {
	
		@Autowired
		WarehouseService warehouseService;
		
		@Autowired
		ProductsRepository productsRepository;

	// api lấy tất cả sản phẩm search theo keyword nhập vào
	@RequestMapping(value = "/getAllWarehouse", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopWarehouseEntity> findListWarehouse(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		try {
			Page<ShopWarehouseEntity> dataUsers = warehouseService.findAllWarehouseByKey(keyword, PageRequest.of(page, size));
			return dataUsers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// api thêm sản phẩm, kiểm tra nếu đã có sản phẩm trùng trên không được thêm
	@RequestMapping(value = "/insert_warehouse", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional
	ResponseEntity<ResponseObject> insertWarehouse(@RequestBody ShopWarehouseEntity shopWarehouseEntity) {
		
		Optional<ShopProductsEntity> foundProducts = productsRepository.findById(shopWarehouseEntity.getProductId());
		if (!foundProducts.isPresent()) {
			System.out.println("chưa tồn tại");
		}
		else {
			
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("200", "Thêm Thành Công ", warehouseService.saveQuantityWarehouse(shopWarehouseEntity)));
	}
	
}
