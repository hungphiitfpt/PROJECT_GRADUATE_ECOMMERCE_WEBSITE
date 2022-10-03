//package com.poly.edu.project.graduation.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.poly.edu.project.graduation.dao.UserRepository;
//import com.poly.edu.project.graduation.model.UsersEntity;
//
//@Controller
//public class LoginController {
//
//	@Autowired
//	private UserRepository userRepo;
//	
//	@GetMapping("index_Home")
//	public String viewHomePage() {
//		return "product/ogani-master/index";
//	}
//	
//	@GetMapping("/login")
//	public String loginForm() {
//		return "admin-template/login";
//	}
//	
//	@GetMapping("/register")
//	public String showRegistrationForm(Model model) {
//		model.addAttribute("user", new UsersEntity());
//		
//		return "admin-template/register";
//	}
//	
//	@PostMapping("/process_register")
//	public String processRegister(UsersEntity user) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//		
//		userRepo.save(user);
//		
//		return "admin-template/login";
//	}
//	
////	@GetMapping("/users")
////	public String listUsers(Model model) {
////		List<UserEntity> listUsers = userRepo.findAll();
////		model.addAttribute("listUsers", listUsers);
////		
////		return "users";
////	}
//}
