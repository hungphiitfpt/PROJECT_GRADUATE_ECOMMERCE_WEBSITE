package com.poly.edu.project.graduation.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.edu.project.graduation.services.UserService;

@Controller
public class MyAccountController {

	@Autowired
	UserService userService;
	@RequestMapping("account")
	public String index(Model model, Principal principal) {
	    model.addAttribute("infoUser",userService.findUserById(principal.getName()));
		return "shop-template/setting-account";
		
	}
}
