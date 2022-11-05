package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;


// lớp này sử dụng để giao tiếp với db
@Service
public interface CategoryServices {

	List<ShopCategoriesEntity> findAll();

	List<ShopCategoriesEntity> findByProductName(String id);

	
	Page<ShopCategoriesEntity> findByKeyWord(String keyword, Pageable pageable);

	void changeStatusIsdeleted(long id);

	void changeStatusInstock(long id);





}



