package com.poly.edu.project.graduation.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopWarehouseEntity;

public interface WarehouseRepository extends JpaRepository<ShopWarehouseEntity, Integer>{

	@Query(value = "SELECT  * from shop_warehouse where id = :keyword "
			+ "OR product_id = :keyword "
			+ "OR quantity =  :keyword "
			+ "OR note =  :keyword "
			+ "OR create_date   LIKE CONCAT('%',:keyword,'%') ", nativeQuery = true)
	Page<ShopWarehouseEntity> findAllWarehouseByKey(String keyword, Pageable pageable);

}
