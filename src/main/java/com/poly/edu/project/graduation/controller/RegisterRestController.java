package com.poly.edu.project.graduation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	 @PostMapping("/signup")
	    public ResponseEntity<?> registerUser(@RequestBody AppUserEntity dto ){

//		   add check for username exists in a DB
	        if(userRepository.existsByUsername(dto.getUserName()) != null){
	            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
	        }
	        else if(userRepository.existsByEmail(dto.getEmail()) != null) {
	        	return new ResponseEntity<>("email is already taken!", HttpStatus.BAD_REQUEST);
            }
	        else {
	        	AppUserEntity user = new AppUserEntity();
	        	user.setUserId(dto.getUserId());
	        	user.setUserName(dto.getUserName());
	        	user.setBirthday(dto.getBirthday());
	        	user.setAddress(dto.getAddress());  
	        	user.setLastName(dto.getLastName());  
	        	user.setFirstName(dto.getFirstName());  
	        	user.setGender(dto.getGender());  
	        	user.setEmail(dto.getEmail());  
	        	user.setAvatar(dto.getAvatar());  
	        	user.setAddress(dto.getAddress());  
	        	user.setCountry(dto.getCountry());  
	        	user.setCity(dto.getCity()); 
	        	user.setAvatar(dto.getAvatar());
	        	String password = passwordEncoder.encode(dto.getEncrytedPassword());
	        	user.setEncrytedPassword(password);
	        
	        	userRepository.save(user);
	        	return new ResponseEntity<>("Thêm Người Dùng Mới Thành Công", HttpStatus.OK);
	        }
			
		
		 
	 }

}
 