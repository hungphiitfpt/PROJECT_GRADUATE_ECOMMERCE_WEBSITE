package com.poly.edu.project.graduation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.WarehouseRepository;
import com.poly.edu.project.graduation.model.ShopWarehouseEntity;
import com.poly.edu.project.graduation.services.WarehouseService;

@Repository
public class WareHouseImpl implements WarehouseService{

	@Autowired
	WarehouseRepository repository;

	@Override
	public ShopWarehouseEntity saveQuantityWarehouse(ShopWarehouseEntity warehouse) {
		// TODO Auto-generated method stub
		return repository.save(warehouse);
	}

	@Override
	public Page<ShopWarehouseEntity> findAllWarehouseByKey(String keyword, Pageable pageable) throws Exception {
		// TODO Auto-generated method stub
		return repository.findAllWarehouseByKey(keyword,pageable);
	}

	

}
