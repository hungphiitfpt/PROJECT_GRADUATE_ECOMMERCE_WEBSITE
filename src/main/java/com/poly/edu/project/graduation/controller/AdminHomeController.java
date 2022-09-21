package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.model.ProductsEntity;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.services.ProductServices;

@Controller
public class AdminHomeController {

	@Autowired
	ProductServices productServices;
	@RequestMapping("/admin/manage_product")
	public String index() {
		
		return "admin-template/templateManageProduct";
			
	}
	
	@PostMapping("add_product")
	ResponseEntity<ResponseObject> functionAddProduct(@RequestBody ProductsEntity product, Model model) {
		try {
			productServices.saveProduct(product);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Thêm Mới Thành Công", null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Thêm mới thất bại", null));
	}
	
//	đăng thay đổi nha
	
}
