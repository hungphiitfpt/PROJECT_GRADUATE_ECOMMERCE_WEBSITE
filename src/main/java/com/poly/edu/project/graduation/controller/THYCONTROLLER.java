package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.Thyservices;

@Controller
public class THYCONTROLLER {
	@Autowired
	Thyservices thyservices;
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		List<ShopProductsEntity> list = thyservices.findAllProductDiscountASC();
		System.out.println(list.size());
		model.addAttribute("items", list);
		return "template/index";
	}
}
