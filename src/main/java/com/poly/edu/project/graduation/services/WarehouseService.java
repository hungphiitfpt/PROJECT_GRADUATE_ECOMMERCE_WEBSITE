package com.poly.edu.project.graduation.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopWarehouseEntity;

@Service
//lớp này sử dụng để tạo ra các phương thức 
public interface WarehouseService {

	Page<ShopWarehouseEntity> findAllWarehouseByKey(String keyword, Pageable pageable) throws Exception;

	ShopWarehouseEntity saveQuantityWarehouse(ShopWarehouseEntity warehouse);
	
}
