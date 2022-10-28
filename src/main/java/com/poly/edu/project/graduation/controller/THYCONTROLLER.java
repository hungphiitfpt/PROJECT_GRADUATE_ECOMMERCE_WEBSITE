package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ReviewProductRepository;

@RestController
@RequestMapping("/api/admin")
public class THYCONTROLLER {

	@Autowired
	ReviewProductRepository productService;
	


	@RequestMapping(value = "/statistics_sales_12_month", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional(rollbackFor = { Exception.class, Throwable.class })
	public String index() {

	

		return "";

	}
}
