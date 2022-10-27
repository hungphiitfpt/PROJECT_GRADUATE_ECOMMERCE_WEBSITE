package com.poly.edu.project.graduation.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopOrdersEntity;

public interface OrderRepository extends JpaRepository<ShopOrdersEntity, Long> {

	@Query(value = " SELECT * FROM shop_orders o " 	
			+ "WHERE (( ':keyword' <> '' AND (o.user_id LIKE CONCAT('%',:keyword,'%') "
			+ "OR o.ship_name LIKE CONCAT('%',:keyword,'%') "
			+ "OR o.ship_address LIKE CONCAT('%',:keyword,'%') "
			+ "OR o.ship_city LIKE CONCAT('%',:keyword,'%') "
			+ "OR o.ship_state LIKE CONCAT('%',:keyword,'%'))) "
			+ "OR ':keyword' = '')", nativeQuery = true)
	Page<ShopOrdersEntity> findByKeyWord(String keyword, Pageable pageable);

}
