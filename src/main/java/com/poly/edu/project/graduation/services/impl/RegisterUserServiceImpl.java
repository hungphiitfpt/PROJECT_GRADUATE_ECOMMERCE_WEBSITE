//package com.poly.edu.project.graduation.services.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.poly.edu.project.graduation.dao.UserRepository;
//import com.poly.edu.project.graduation.model.UsersEntity;
//import com.poly.edu.project.graduation.services.RegisterUserService;
//
//@Repository
//public class RegisterUserServiceImpl implements RegisterUserService {
//
//	@Autowired
//	UserRepository userRepository;
//
//	// phương thức đăng ký user
//	@Override
//	public void save(UsersEntity user) {
//		userRepository.save(user);
//	}
//
//	// phương thức kiểm tra trùng username trong hệ thống
//	@Override
//	public Boolean existsByUsername(String username) {
//		// TODO Auto-generated method stub
//		return userRepository.existsByUsername(username);
//
//	}
//
////	phương thức kiểm tra đã tồn tại email trong hệ thống
//	@Override
//	public Boolean existsByEmail(String email) {
//		// TODO Auto-generated method stub
//		return userRepository.existsByEmail(email);
//	}
//
//}
