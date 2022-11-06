package com.poly.edu.project.graduation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopBlogsEntity;

public interface BlogRepository extends JpaRepository<ShopBlogsEntity, Integer>{

	@Query(value="SELECT * FROM shop_blogs  WHERE is_deleted = false", nativeQuery = true)
	List<ShopBlogsEntity> findAllBlogShop();

	@Query(value="SELECT * FROM shop_blogs  WHERE id = ?1", nativeQuery = true)
	ShopBlogsEntity findById(Long id);

}
