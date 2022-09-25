package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.UserRepository;
import com.poly.edu.project.graduation.model.UserEntity;
import com.poly.edu.project.graduation.services.RegisterUserService;

@RestController
public class RegisterController {

	@Autowired
	RegisterUserService registerUserService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity) {
		
		

		// create user object
		UserEntity user = new UserEntity();
		user.setAddress(userEntity.getAddress());
		user.setBirthday(userEntity.getBirthday());
		user.setCity(userEntity.getCity());
		user.setCmnd(userEntity.getCmnd());
		user.setCountry(userEntity.getCountry());
		user.setEmail(userEntity.getEmail());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		user.setUsername(userEntity.getUsername());
//	        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
//	        user.setRoles(Collections.singleton(roles));

		registerUserService.save(user);

		return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);

	}
}
