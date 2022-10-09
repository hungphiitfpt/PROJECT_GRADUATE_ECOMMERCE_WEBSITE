package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;

@Service
public interface ReviewProductService {

	List<ShopProductReviewsEntity> findAllReviewProduct(Long id);

}
