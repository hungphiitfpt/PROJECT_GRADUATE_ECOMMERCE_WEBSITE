//package com.poly.edu.project.graduation.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.poly.edu.project.graduation.model.UsersEntity;
//import com.poly.edu.project.graduation.services.RegisterUserService;
//
//@RestController
//public class RegisterController {
//
//	@Autowired
//	RegisterUserService registerUserService;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@GetMapping("/registerUser")
//	public ResponseEntity<?> registerUser(@RequestBody UsersEntity userEntity) {
//		
//		
//
//		// create user object
//		UsersEntity user = new UsersEntity();
//		user.setAddress(userEntity.getAddress());
//		user.setBirthday(userEntity.getBirthday());
//		user.setCity(userEntity.getCity());
//		user.setCmnd(userEntity.getCmnd());
//		user.setCountry(userEntity.getCountry());
//		user.setEmail(userEntity.getEmail());
//		user.setFirstname(userEntity.getFirstname());
//		user.setLastname(userEntity.getLastname());
//		user.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//		user.setUsername(userEntity.getUsername());
////	        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
////	        user.setRoles(Collections.singleton(roles));
//
//		registerUserService.save(user);
//
//		return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
//
//	}
//}
