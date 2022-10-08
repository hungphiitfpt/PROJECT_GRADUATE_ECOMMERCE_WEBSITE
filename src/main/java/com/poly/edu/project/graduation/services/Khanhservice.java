package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopCategoriesEntity;

@Service
public interface Khanhservice {

	List<ShopCategoriesEntity> findAllCategory();
}
