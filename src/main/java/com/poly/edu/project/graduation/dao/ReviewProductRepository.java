package com.poly.edu.project.graduation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;

public interface ReviewProductRepository extends JpaRepository<ShopProductReviewsEntity, Long> {

	@Query(value = "SELECT * from shop_product_reviews WHERE shop_product_reviews.product_id = ?1", nativeQuery = true)
	List<ShopProductReviewsEntity> findAllReviewProduct(Long id);



	@Query(value = "select * from shop_product_reviews", nativeQuery = true)
	List<ShopProductReviewsEntity> countReviewProducts(Long id);

}
