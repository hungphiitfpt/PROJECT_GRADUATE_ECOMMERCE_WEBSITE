package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.model.ShopSuplierEntity;
import com.poly.edu.project.graduation.services.SupplierService;

@RestController
@RequestMapping("/api/graduation/")

public class SupplierRestController {
	@Autowired
	SupplierService service;

	@RequestMapping("getAllSupplider")
	public List<ShopSuplierEntity> getAllSupplider() {

		return service.findAllSupplier();

	}
}
