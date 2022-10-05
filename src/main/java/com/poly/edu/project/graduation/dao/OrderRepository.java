package com.poly.edu.project.graduation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.edu.project.graduation.model.ShopOrdersEntity;

public interface OrderRepository  extends JpaRepository<ShopOrdersEntity, Long>{

}
