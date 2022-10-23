package com.poly.edu.project.graduation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.ReviewProductRepository;
import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;
import com.poly.edu.project.graduation.services.ReviewProductService;

@Repository
public class ReviewProductServiceImpl implements ReviewProductService {

	@Autowired
	ReviewProductRepository reviewProductRepository;

	@Override
	public List<ShopProductReviewsEntity> findAllReviewProduct(Long id) {
		// TODO Auto-generated method stub
		return reviewProductRepository.findAllReviewProduct(id);
	}



}
