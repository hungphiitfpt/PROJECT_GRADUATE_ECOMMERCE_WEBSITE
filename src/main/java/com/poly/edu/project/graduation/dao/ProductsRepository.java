package com.poly.edu.project.graduation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.edu.project.graduation.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
//	@Query(value ="{CALL getAllProduct()}" ,nativeQuery = true)
//	List<ProductDataModel> getAllProducts() throws Exception;
}
