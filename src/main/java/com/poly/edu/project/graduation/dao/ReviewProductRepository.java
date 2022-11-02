package com.poly.edu.project.graduation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.MonthDTO;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;

public interface ReviewProductRepository extends JpaRepository<ShopProductReviewsEntity, Long> {

	@Query(value = "SELECT * from shop_product_reviews WHERE shop_product_reviews.product_id = ?1", nativeQuery = true)
	List<ShopProductReviewsEntity> findAllReviewProduct(Long id);



	@Query(value = "select * from shop_product_reviews", nativeQuery = true)
	List<ShopProductReviewsEntity> countReviewProducts(Long id);
	
//	@Query(value = "SELECT SUM(total_price) "
//			+ "FROM shop_orders AS January WHERE order_date LIKE CONCAT('%','2022-01','%') "
//			+ "UNION "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders AS February WHERE order_date LIKE CONCAT('%','2022-02','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders AS March WHERE order_date LIKE CONCAT('%','2022-03','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders AS April WHERE order_date LIKE CONCAT('%','2022-04','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders AS May WHERE order_date LIKE CONCAT('%','2022-05','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders AS June WHERE order_date LIKE CONCAT('%','2022-06','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders WHERE AS July order_date LIKE CONCAT('%','2022-07','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders WHERE AS August order_date LIKE CONCAT('%','2022-08','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders WHERE AS September order_date LIKE CONCAT('%','2022-09','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders WHERE AS October order_date LIKE CONCAT('%','2022-10','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders WHERE AS November order_date LIKE CONCAT('%','2022-11','%') "
//			+ "UNION  "
//			+ "SELECT SUM(total_price) "
//			+ "FROM shop_orders WHERE AS December order_date LIKE CONCAT('%','2022-12','%') ", nativeQuery = true)
//	@Query(value = "SELECT SUM(total_price) FROM shop_orders AS January "
//			+ "WHERE order_date LIKE CONCAT('%','2022-09','%') ", nativeQuery = true)
//	

@Query(value = " "
		+ "SELECT (sum(total_price))  FROM shop_orders where created_at LIKE CONCAT('%2022-01%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-02%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-03%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-04%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-05%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-06%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-07%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-08%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-09%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-10%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-11%') "
		+ "UNION ALL "
		+ "SELECT (sum(total_price)) FROM shop_orders where created_at LIKE CONCAT('%2022-12%')", nativeQuery = true)
List<String> getTotalPrice();


@Query(value = "select GROUP_CONCAT(shop_order_detail.product_id ) "
		+ "from shop_order_detail "
		+ "LEFT JOIN shop_orders "
		+ "ON shop_order_detail.order_id = shop_orders.id where shop_orders.id = 104;", nativeQuery = true)
String updatelist();



}
