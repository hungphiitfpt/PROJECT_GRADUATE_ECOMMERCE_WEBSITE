package com.poly.edu.project.graduation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.Products;

// lớp này sử dụng để giao tiếp với db
@Service
public interface ProductServices {

	List<Products> findAllProducts() throws Exception;

	void saveProduct(Products products) throws Exception;

	void deleteProductById(int id) throws Exception;  

	Optional<Products> findProductById(int id) throws Exception;


}
