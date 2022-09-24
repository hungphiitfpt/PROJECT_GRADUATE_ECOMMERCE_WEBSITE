package com.poly.edu.project.graduation.services;

import java.util.List;
import java.util.Optional;

import com.poly.edu.project.graduation.model.ProductsEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// lớp này sử dụng để giao tiếp với db
@Service
// lớp này sử dụng để tạo ra các phương thức 
public interface ProductServices {

	ProductsEntity findProductById(Integer id);
	List<ProductsEntity> findAllProducts();

	void saveProduct(ProductsEntity products);

	void deleteProductById(int id);  

//	Optional<ProductsEntity> findProductById(int id);

	List<ProductsEntity> findAllProductSaleOff();

	Page<ProductsEntity> findAllBy(String category, String name, String size, String color, String price, Pageable pageable);

	
}
