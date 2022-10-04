package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

@Service
public interface Thyservices {

	public ShopProductsEntity findProductById(Integer id);

	public List<ShopProductsEntity> findAllProductDiscountASC();

	List<ShopProductsEntity> findAll();
}
