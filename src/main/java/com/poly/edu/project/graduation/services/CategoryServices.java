package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopCategoriesEntity;


// lớp này sử dụng để giao tiếp với db
@Service
public interface CategoryServices {

	List<ShopCategoriesEntity> findAll();

}
