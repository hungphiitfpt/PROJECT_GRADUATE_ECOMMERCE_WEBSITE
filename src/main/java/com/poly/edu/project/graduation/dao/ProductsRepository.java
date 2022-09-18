package com.poly.edu.project.graduation.dao;

import com.poly.edu.project.graduation.model.ProductsEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
	
	// STORE PROCEDURE đã được viết sẵn trong mysql thay vì viết câu lệnh tại đây
	@Query(value ="{CALL findAllProductSaleOff()}" ,nativeQuery = true)
	List<ProductsEntity> findAllProductSaleOff();

//	@Query(value ="SELECT * FROM products WHERE quantity > 0 AND category LIKE %% AND name LIKE %:name% AND size LIKE %% AND color LIKE %% AND price LIKE %%" ,nativeQuery = true)
//	Page<ProductsEntity> findAllBy(@Param("name") String name, Pageable pageable);
	
	@Query(value ="SELECT * FROM products WHERE quantity > 0 AND category LIKE %:category% AND name LIKE %:name% AND size LIKE %:size% AND color LIKE %:color% AND price LIKE %:price%" ,nativeQuery = true)
	Page<ProductsEntity> findAllBy(@Param("category") String category, @Param("name") String name, @Param("size") String size, @Param("color") String color, @Param("price") String price, Pageable pageable);
	
//	@Query(value ="{CALL getAllProduct()}" ,nativeQuery = true)
//	List<ProductDataModel> getAllProducts() throws Exception;
}
