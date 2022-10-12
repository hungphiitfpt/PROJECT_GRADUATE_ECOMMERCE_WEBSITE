package com.poly.edu.project.graduation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;

public interface ReviewProductRepository extends JpaRepository<ShopProductReviewsEntity, Long> {

	@Query(value = "SELECT shop_product_reviews.one_stars, shop_product_reviews.two_stars , "
			+ "shop_product_reviews.three_stars, shop_product_reviews.four_stars , "
			+ "shop_product_reviews.five_stars, shop_product_reviews.updated_at ,"
			+ "shop_product_reviews.product_id,shop_product_reviews.is_deleted,"
			+ "shop_product_reviews.customer_id,shop_product_reviews.created_at,"
			+ "shop_product_reviews.comment,shop_product_reviews.id,shop_customer.last_name "
			+ "FROM shop_product_reviews  LEFT JOIN shop_customer "
			+ "ON shop_product_reviews.customer_id = shop_customer.id  "
			+ "WHERE shop_product_reviews.product_id = ?1 ", nativeQuery = true)
	List<ShopProductReviewsEntity> findAllReviewProduct(Long id);



	@Query(value = "select * from shop_product_reviews", nativeQuery = true)
	List<ShopProductReviewsEntity> countReviewProducts(Long id);

}
