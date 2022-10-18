package com.poly.edu.project.graduation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

public interface CategoryRepository extends JpaRepository<ShopCategoriesEntity, Long> {
	@Query(value = "SELECT c.id, c.category_code, c.image, c.category_name "
				 + "FROM shop_categories as c WHERE is_deleted = false", nativeQuery = true)
		List<CategoryRepository> findAllCategory();

	// Câu lệnh query lấy tất cả sản phẩm theo tên sản phẩm
	@Query("SELECT u FROM ShopCategoriesEntity u WHERE u.categoryName = ?1")
	List<ShopCategoriesEntity> findByProductName(String id);
	
	// Câu lệnh tìm kiếm sản phẩm theo nhiều điều kiện
	@Query(value ="SELECT * FROM shop_categories  where shop_categories.is_deleted = false "
			+ "AND shop_categories.id 				    LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_categories.category_code 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_categories.category_name 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_categories.description 		    LIKE CONCAT('%',:keyword,'%') " ,nativeQuery = true)
	Page<ShopCategoriesEntity> findByKeyWord(@Param("keyword") String keyword, Pageable pageable);

	@Modifying  
	@Transactional
	@Query(value = "UPDATE ShopCategoriesEntity SET isDeleted = TRUE WHERE id = ?1")
	void changeStatusIsdeleted(long id);
	
	@Modifying  
	@Transactional
	@Query(value = "UPDATE ShopCategoriesEntity SET isDeleted = FALSE WHERE id = ?1")
	void changeIstock(long id);


}

