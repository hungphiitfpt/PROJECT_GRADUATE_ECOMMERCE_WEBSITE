package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.OrderRepository;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.services.OrderService;

@RestController
@RequestMapping("api/admin")
public class OrderRestController {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/getOrderProducts", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopOrdersEntity> index(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		Page<ShopOrdersEntity> dataOrders = orderService.findByKeyWord(keyword, PageRequest.of(page, size));
		return dataOrders;
	}

	@RequestMapping(value = "/changeStatusOrders", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void changeStatusOrders(@RequestParam(name = "status", required = false, defaultValue = "") Long status,
			@RequestParam(name = "update_at", required = false) String update_at,
			@RequestParam(name = "shipped_date", required = false) String shipped_date,
			@RequestParam(name = "id", required = false, defaultValue = "") Long id) {
		try {
			orderRepository.changeStatusOrder(status, update_at, shipped_date, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/countUserOrderDateNow", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String countOrdersDateNow() {
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String numberOrders = orderService.countNumberOrders(date);
			return numberOrders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/TotalPriceOrderDateNow", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String TotalPriceOrderDateNow() {
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String totalPriceOrders = orderService.totalPriceOrdersDateNow(date);
			return totalPriceOrders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/CountOrdersDateNow", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String CountUsersOrders() {
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String totalPriceOrders = orderService.CountOrdersDateNow(date);
			return totalPriceOrders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
