package com.poly.edu.project.graduation.dao;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopOrdersEntity;

public interface OrderRepository extends JpaRepository<ShopOrdersEntity, Long> {

	@Query(value = " SELECT * FROM shop_orders  " 	
			+ "WHERE (( :keyword <> '' AND (shop_orders.user_id LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_orders.ship_name LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_orders.ship_address LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_orders.ship_city LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_orders.ship_state LIKE CONCAT('%',:keyword,'%'))) "
			+ "OR :keyword = '')", nativeQuery = true)
	Page<ShopOrdersEntity> findByKeyWord(String keyword, Pageable pageable);
	
	@Query(value = " SELECT * FROM shop_orders where id = ?1", nativeQuery =  true)
	ShopOrdersEntity findOrdersDetailById(Long id);
	
	@Modifying  
	@Query(value = "UPDATE shop_orders SET order_status = :status, updated_at = :update_at, "
			+ "shipped_date = :shipped_date WHERE id  = :id ", nativeQuery = true)
	@Transactional
	void changeStatusOrder(Long status, String update_at, String shipped_date,Long id);

}
