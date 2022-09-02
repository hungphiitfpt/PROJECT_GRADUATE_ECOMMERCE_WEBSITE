package com.poly.edu.project.graduation.controller;

import java.util.List;

import com.poly.edu.project.graduation.model.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.services.ProductServices;

@RestController
@RequestMapping("/api/graduation/products/")
public class ProductsController {
	@Autowired
	ProductServices productServices;
	@Autowired
	ProductsRepository productsRepository;

	@RequestMapping("getListProduct")
	public List<ProductsEntity> getAllProduct() {
		try {
			 
			List<ProductsEntity> dataProduct = productServices.findAllProducts();
			return dataProduct;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 
	@PostMapping("delete/{id}")
	ResponseEntity<ResponseObject> deleteProductById(@PathVariable int id, Model model) {
		boolean exitsProduct = productsRepository.existsById(id);
		if (exitsProduct) {
			try {
				productServices.deleteProductById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Xoá Thành Công", null));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Xoá thất bại", null));
	}
	@PostMapping("add")
	ResponseEntity<ResponseObject> addProducts(@RequestBody ProductsEntity product, Model model) {
		try {
			productServices.saveProduct(product);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Thêm Mới Thành Công", getAllProduct()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Xoá thất bại", null));
	}

	@PostMapping("update/{id}")
	ResponseEntity<ResponseObject> updateProductById(@RequestBody ProductsEntity prd, @PathVariable int id) {
		try {
			ProductsEntity updatedProduct = productsRepository.findById(id).map(product -> {
				product.setCategory(prd.getCategory());
				product.setName(prd.getName());
				product.setSize(prd.getSize());
				product.setImage(prd.getImage());
				product.setColor(prd.getColor());
				product.setPrice(prd.getPrice());
				return productsRepository.save(product);
			}).orElseGet(() -> {
				prd.setIdproduct(id);
				return productsRepository.save(prd);
			});
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("ok", "Cập nhật thành công", null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObject("failed", "Cập nhật thất bại", null));
		}

	}
}
