package com.poly.edu.project.graduation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.CategoryRepository;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.services.CategoryServices;

@Repository
public class CategoryServicesImpl implements CategoryServices {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<ShopCategoriesEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}