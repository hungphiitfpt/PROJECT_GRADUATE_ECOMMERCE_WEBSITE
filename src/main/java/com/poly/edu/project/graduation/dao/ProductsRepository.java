package com.poly.edu.project.graduation.dao;

import com.poly.edu.project.graduation.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
//	@Query(value ="{CALL getAllProduct()}" ,nativeQuery = true)
//	List<ProductDataModel> getAllProducts() throws Exception;
}
