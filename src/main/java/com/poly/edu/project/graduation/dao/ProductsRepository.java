package com.poly.edu.project.graduation.dao;

import com.poly.edu.project.graduation.model.ProductsEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
//	@Query(value ="{CALL getAllProduct()}" ,nativeQuery = true)
//	List<ProductDataModel> getAllProducts() throws Exception;
	@Query(value ="select count(idproduct) from products where category = 1 union  select count(idproduct) from products where category = 2 union select count(idproduct) from products where category = 3 " ,nativeQuery = true)
    List<ProductsEntity> getReport();
}
