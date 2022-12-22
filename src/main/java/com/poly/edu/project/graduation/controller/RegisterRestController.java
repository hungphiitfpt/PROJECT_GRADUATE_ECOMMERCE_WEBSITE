package com.poly.edu.project.graduation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.UserRepository;
import com.poly.edu.project.graduation.model.AppUserEntity;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
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
	 
		@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = {
				MediaType.APPLICATION_JSON_UTF8_VALUE })
	    public ResponseEntity<?> updateUser(@RequestBody AppUserEntity dto , @Param("id") Long id){

			AppUserEntity appUserEntity = userRepository.findById(id).map(user -> {
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
	        	return userRepository.save(user);
			}).orElseGet(() -> {
				dto.setUserId(0);
				return userRepository.save(dto);
			});

			// xử lý cập nhật danh mục đó mà trả về trạng trái OK 200
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("ok", "Update Product successfully", appUserEntity));
		 
	 }

}
 