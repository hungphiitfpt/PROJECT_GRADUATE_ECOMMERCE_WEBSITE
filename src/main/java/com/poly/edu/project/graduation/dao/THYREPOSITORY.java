package com.poly.edu.project.graduation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

public interface THYREPOSITORY extends JpaRepository<ShopProductsEntity, Long> {

	@Query(value = "FROM ShopProductsEntity p WHERE p.isDeleted = false and p.discountinued > 0 "
			+ "ORDER BY p.listPrice ASC")
	List<ShopProductsEntity> findAllProductDiscountASC();
	
//	@Query(value = "SELECT p.product_code, p.product_name, "
//			+ "p.image, p.discountinued FROM shop_products "
//			+ "as p where is_deleted = false and p.discountinued > 0 "
//			+ "order by p.discountinued ASC", nativeQuery = true)
//		List<ShopProductsEntity> findAllProductDiscountASC();
	
}
