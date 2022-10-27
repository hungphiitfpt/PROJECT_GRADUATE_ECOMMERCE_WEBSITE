package com.poly.edu.project.graduation.controller;

import java.util.HashMap;
import java.util.Map;

import com.poly.edu.project.graduation.model.CartEntity;
import com.poly.edu.project.graduation.model.ShopOrderDetailEntity;

public class Utils {
	/**
	 * 
	 * @param truyền vào đối tượng cartcart
	 * @return trả về số lượng sản phẩm vừa thêm vào giỏ hàng
	 */
	public static int countCart(Map<Long, CartEntity> cart) {
		int quantity = 0;

		if (cart != null)
			for (CartEntity c : cart.values())
				quantity += c.getQuantity();
		return quantity;
	}
	
	/**
	 * 
	 * @param truyền vào 1 đối tượng cart 
	 * @return
	 */
	public static Map<String, String>cartStarts(Map<Long, CartEntity> cart){
		Long totalPrice = 0l;
		int quantity = 0;
		if (cart != null)
			for (CartEntity s : cart.values()) {
				quantity += s.getQuantity();
				totalPrice += s.getQuantity() * s.getPrice();
			}
		Map<String, String>  kq = new HashMap<>();
		kq.put("counter", String.valueOf(quantity));
		kq.put("amount", String.valueOf(totalPrice));
		return kq;

	}
}
