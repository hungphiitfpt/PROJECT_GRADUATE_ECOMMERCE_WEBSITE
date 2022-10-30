package com.poly.edu.project.graduation.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopWarehouseEntity;

public interface WarehouseRepository extends JpaRepository<ShopWarehouseEntity, Integer>{

	@Query(value = "SELECT * FROM shop_warehouse  WHERE (( :keyword <> '' AND (shop_warehouse.note LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_warehouse.product_id LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_warehouse.quantity LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_warehouse.create_date LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_warehouse.status LIKE CONCAT('%',:keyword,'%'))) "
			+ "OR :keyword = '')", nativeQuery = true)
	Page<ShopWarehouseEntity> findAllWarehouseByKey(String keyword, Pageable pageable);

}
