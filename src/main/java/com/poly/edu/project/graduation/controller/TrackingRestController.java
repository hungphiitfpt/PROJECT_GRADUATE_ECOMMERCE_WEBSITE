package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.services.OrderService;

@RestController
@RequestMapping("api/graduation")
public class TrackingRestController {
	@Autowired
	OrderService orderService;

	@RequestMapping(value = {"/tracking-order"}, method = RequestMethod.GET)
	public List<ShopOrdersEntity> index(@RequestParam("id") String id) throws Exception{
		if(id == "") {
			return null;
		}
		return orderService.findOrderByIdUser(id);
	}
	
	@RequestMapping(value = {"/order_cancel"}, method = RequestMethod.POST)
	public void orderCancel(@RequestParam("id") long id) throws Exception{
		orderService.cancelOrderById(id);
	}
}
