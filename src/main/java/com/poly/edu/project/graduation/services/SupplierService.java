package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopSuplierEntity;

@Service
public interface SupplierService {

	List<ShopSuplierEntity> findAllSupplier();


}


