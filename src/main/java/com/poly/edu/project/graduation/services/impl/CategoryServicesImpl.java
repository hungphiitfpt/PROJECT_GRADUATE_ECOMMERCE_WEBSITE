package com.poly.edu.project.graduation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poly.edu.project.graduation.dao.CategoryRepository;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
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

	@Override
	public List<ShopCategoriesEntity> findByProductName(String id) {
		// TODO Auto-generated method stub
		return categoryRepository.findByProductName(id);
	}

	@Override
	public Page<ShopCategoriesEntity> findByKeyWord(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepository.findByKeyWord(keyword, pageable);
	}

	@Override
	public void changeStatusIsdeleted(long id) {
		// TODO Auto-generated method stub
		 categoryRepository.changeStatusIsdeleted(id);
	}

	@Override
	public void changeStatusInstock(long id) {
		// TODO Auto-generated method stub
		 categoryRepository.changeIstock(id);
	}


	

}
