package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.OrderRepository;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.OrderService;

@RestController
@RequestMapping("api/admin")
public class OrderRestController {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderService orderService;
	@RequestMapping(value = "/getOrderProducts", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopOrdersEntity> index(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception{
		Page<ShopOrdersEntity> dataOrders = orderService.findByKeyWord(keyword, PageRequest.of(page, size));
		return dataOrders;
	}
}
