package com.poly.edu.project.graduation.services;

import java.util.List;
import java.util.Optional;

import com.poly.edu.project.graduation.model.ProductsEntity;
import org.springframework.stereotype.Service;

// lớp này sử dụng để giao tiếp với db
@Service
public interface ProductServices {

	List<ProductsEntity> findAllProducts() throws Exception;

	void saveProduct(ProductsEntity products) throws Exception;

	void deleteProductById(int id) throws Exception;  

	Optional<ProductsEntity> findProductById(int id) throws Exception;




}
