package com.poly.edu.project.graduation.services.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.controller.Utils;
import com.poly.edu.project.graduation.dao.OrderDetailRepository;
import com.poly.edu.project.graduation.dao.OrderRepository;
import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.CartEntity;
import com.poly.edu.project.graduation.model.ShopOrderDetailEntity;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.services.OrderService;

@Repository
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductsRepository productsRepository;

	@Autowired
	OrderDetailRepository detailRepository;

	/*
	 * Tạo phiếu order
	 */
	@Override
	@Transactional(rollbackOn  = {Exception.class, Throwable.class})
	public boolean CreateOrder(Map<Long, CartEntity> cart,HttpSession session) {
		try {
			ShopOrdersEntity ordersEntity = (ShopOrdersEntity) session.getAttribute("userInf");
			ordersEntity.setUserId(ordersEntity.getUserId());
			ordersEntity.setShipName(ordersEntity.getShipName());
			ordersEntity.setShipAddress(ordersEntity.getShipAddress().trim());
			ordersEntity.setShipCity(ordersEntity.getShipCity());
			ordersEntity.setShipState(ordersEntity.getShipState());
			ordersEntity.setShippingFee(ordersEntity.getShippingFee());
			ordersEntity.setPaymentTypeId(ordersEntity.getPaymentTypeId());
			ordersEntity.setOrderStatus(0);
			Map<String, String> stats = Utils.cartStarts(cart);
			ordersEntity.setTotalPrice(Integer.parseInt(stats.get("amount")));
			
			orderRepository.save(ordersEntity);
			for (CartEntity s : cart.values()) {
				ShopOrderDetailEntity detailEntity = new ShopOrderDetailEntity();
			
				detailEntity.setId(0);
				detailEntity.setOrderId(ordersEntity.getId());
				detailEntity.setProductId(s.getProductId());
				detailEntity.setPrice(s.getPrice());
				detailEntity.setProductName(s.getProductName());
				detailEntity.setQuantity(s.getQuantity());
				detailEntity.setImage(s.getImage());

				detailRepository.save(detailEntity);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * Truy vấn danh sách ORDER theo keyword truyền vào, có sử dụng phân trang
	 */
	@Override
	public Page<ShopOrdersEntity> findByKeyWord(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderRepository.findByKeyWord(keyword,pageable);
	}

	@Override
	public ShopOrdersEntity findOrdersDetailById(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findOrdersDetailById(id);
	}

	@Override
	public List<ShopOrdersEntity> findOrderByIdUser(String id) {
		// TODO Auto-generated method stub
		return orderRepository.findByUserId(id);
	}

	@Override
	public void cancelOrderById(long id) {
		// TODO Auto-generated method stub
		orderRepository.cancelOrderById(id);
	}


}
