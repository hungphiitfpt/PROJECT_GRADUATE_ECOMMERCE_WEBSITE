package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.OrderRepository;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;

@RestController
@RequestMapping("api/admin")
public class OrderRestController {

	@Autowired
	OrderRepository orderRepository;
	@GetMapping("GET_ORDER_ALL")
	public List<ShopOrdersEntity> index() {
		return orderRepository.findAll();
		
	}
}
