package com.poly.edu.project.graduation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.UserRepository;
import com.poly.edu.project.graduation.model.AppUserEntity;
import com.poly.edu.project.graduation.model.SignUpDto;
import com.poly.edu.project.graduation.services.UserService;

@RestController
public class RegisterRestController {
	
	@Autowired
	UserRepository userRepository;
	
//	 @PostMapping("/signup")
//	    public ResponseEntity<?> registerUser(@RequestBody SignUpDto dto ){
//
////		   add check for username exists in a DB
//	        if(userRepository.existsByUsername(dto.getUser_name())){
//	            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//	        }
//	        
//			return null;
//		 
//	 }

}
 