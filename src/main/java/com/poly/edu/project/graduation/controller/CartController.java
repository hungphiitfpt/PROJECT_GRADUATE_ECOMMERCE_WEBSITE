package com.poly.edu.project.graduation.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.edu.project.graduation.model.CartEntity;
import com.poly.edu.project.graduation.model.ShopOrderDetailEntity;
import com.poly.edu.project.graduation.services.ProductServices;

@Controller
public class CartController {
	
	@Autowired
	ProductServices productServices;

	/*
	 * Hiển thị danh sách giỏ hàng từ session
	 */
	@RequestMapping("order-page")
	public String index(Model model, HttpSession session) {

		Map<Long, CartEntity> cartItems = (Map<Long, CartEntity>) session.getAttribute("cart");
		  if(cartItems != null) {
			  model.addAttribute("cart", cartItems.values());
		  } else {
			  model.addAttribute("cart", null);
		  }
		  model.addAttribute("cartStarts", Utils.cartStarts(cartItems));
		// Trả về trang shop cart
		return "shop-template/shop-cart";
		
	}
	

}
