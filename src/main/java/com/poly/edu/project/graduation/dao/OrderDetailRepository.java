package com.poly.edu.project.graduation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.edu.project.graduation.model.ShopOrderDetailEntity;

public interface OrderDetailRepository  extends JpaRepository<ShopOrderDetailEntity, Long>{

}
