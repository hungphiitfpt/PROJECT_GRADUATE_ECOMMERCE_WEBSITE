package com.poly.edu.project.graduation.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.edu.project.graduation.model.CartEntity;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;

@Controller
public class CheckOutController {

	@RequestMapping(value = {"/checkout", "/addInfoUser"}, method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		Map<Long, CartEntity> cartItems = (Map<Long, CartEntity>) session.getAttribute("cart");
		if (cartItems != null) {
			model.addAttribute("cart", cartItems.values());
		} else {
			model.addAttribute("cart", null);
		}
		model.addAttribute("cartStarts", Utils.cartStarts(cartItems));
		return "shop-template/checkout";

	}
	

	  @RequestMapping(value = "/addInfoUser", method = RequestMethod.POST)
	  public String doAddEmployee(@ModelAttribute("employee") ShopOrdersEntity employee, ModelMap modelMap,HttpSession session) { 
	    session.setAttribute("userInf", employee);
	    return "redirect:/order-page";
	  }

}
