package com.poly.edu.project.graduation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.THYREPOSITORY;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.Thyservices;

@Repository
public class ThyServiceImpl implements Thyservices {
	@Autowired
	THYREPOSITORY repository;

	@Override
	public ShopProductsEntity findProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopProductsEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<ShopProductsEntity> findAllProductDiscountASC() {
		// TODO Auto-generated method stub
		return repository.findAllProductDiscountASC();
	}
}
