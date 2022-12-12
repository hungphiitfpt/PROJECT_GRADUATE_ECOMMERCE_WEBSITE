package com.poly.edu.project.graduation.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poly.edu.project.graduation.model.CartEntity;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.services.UserService;

@Controller
public class CheckOutController {
	
	@Autowired
	UserService service;

	@RequestMapping(value = {"/checkout", "/addInfoUser"}, method = RequestMethod.GET)
	public String index(Model model, HttpSession session, Principal principal) throws Exception{
		try {
			if(principal.getName() == null) {
			
				return "shop-template/shop";
			}
			else {
				Map<Long, CartEntity> cartItems = (Map<Long, CartEntity>) session.getAttribute("cart");
				String id = service.findIdUserByPrincipal(principal.getName());
				session.setAttribute("idUsser", id);
			
				if (cartItems != null) {
					model.addAttribute("cart", cartItems.values());
				} else {
					model.addAttribute("cart", null);
				}
				model.addAttribute("cartStarts", Utils.cartStarts(cartItems));
				return "shop-template/checkout";
			}
		} catch (NullPointerException ex) {
			System.out.println(ex);
			model.addAttribute("messageBuyCart","Bạn phải đăng nhập mới có thể đặt hàng");
			System.out.println(model.getAttribute("messageBuyCart"));
			return "redirect:/login";
		}

	}
	

	  @RequestMapping(value = "/addInfoUser", method = RequestMethod.POST)
	  public String doAddEmployee(@ModelAttribute("employee") ShopOrdersEntity employee, ModelMap modelMap,HttpSession session) { 
	    session.setAttribute("userInf", employee);
	    System.out.println(employee.getShippingFee());
	    return "redirect:/order-page";
	  }

}
