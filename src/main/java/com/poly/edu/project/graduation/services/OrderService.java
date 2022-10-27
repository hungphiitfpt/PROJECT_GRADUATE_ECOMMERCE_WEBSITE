package com.poly.edu.project.graduation.services;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.CartEntity;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

@Service
public interface OrderService {

//	boolean CreateOrder(Map<Long, CartEntity> cart);

	boolean CreateOrder(Map<Long, CartEntity> cart, HttpSession session);
	
	Page<ShopOrdersEntity> findByKeyWord(String keyword, Pageable pageable);
	
}
