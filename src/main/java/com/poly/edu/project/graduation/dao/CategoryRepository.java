package com.poly.edu.project.graduation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

public interface CategoryRepository extends JpaRepository<ShopCategoriesEntity, Long> {
	@Query(value = "SELECT c.id, c.category_code, c.image, c.category_name "
				 + "FROM shop_categories as c WHERE is_deleted = false", nativeQuery = true)
		List<CategoryRepository> findAllCategory();

}

