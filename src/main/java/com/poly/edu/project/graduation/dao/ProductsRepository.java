package com.poly.edu.project.graduation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

public interface ProductsRepository extends JpaRepository<ShopProductsEntity, Long> {
	
	// Câu lệnh query lấy tất cả sản phẩm theo tên sản phẩm
	@Query("SELECT u FROM ShopProductsEntity u WHERE u.productName = ?1")
	List<ShopProductsEntity> findByName(String name);
	
	// Câu lệnh tìm kiếm sản phẩm theo nhiều điều kiện
	@Query(value ="SELECT * FROM shop_products  where shop_products.is_deleted = false "
			+ "AND shop_products.id 				LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.product_code 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.product_name 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.list_price 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.discountinued 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.quantity_per_unit 	LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.category_id 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.quantity_per_unit 	LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.image 				LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.created_at 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.updated_at 			LIKE CONCAT('%',:keyword,'%') " ,nativeQuery = true)
	Page<ShopProductsEntity> findByKeyWord(@Param("keyword") String keyword, Pageable pageable);
	
	@Query("SELECT u FROM ShopProductsEntity u WHERE u.id = ?1")
	ShopProductsEntity findProductById(Long id);
	
	@Query(value ="SELECT * FROM shop_products WHERE is_deleted = false "
			+ "and category_id = :idCategory ", nativeQuery = true)
	Page<ShopProductsEntity> findAll(@Param("idCategory") String idCategory, PageRequest pageRequest);
	
	@Query(value = "SELECT * FROM shop_products WHERE is_deleted = false AND category_id = ?1 "
			+ "ORDER BY RAND() LIMIT 4 ", nativeQuery = true)
	List<ShopProductsEntity> findProductRandomById(String idCategory);

}
