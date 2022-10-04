package com.poly.edu.project.graduation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.SupplierRepository;
import com.poly.edu.project.graduation.model.ShopSuplierEntity;
import com.poly.edu.project.graduation.services.SupplierService;

@Repository
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public List<ShopSuplierEntity> findAllSupplier() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}


}

	
