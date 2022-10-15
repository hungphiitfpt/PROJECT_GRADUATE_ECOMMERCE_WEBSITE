package com.poly.edu.project.graduation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.UserRepository;
import com.poly.edu.project.graduation.model.UserEntity;
import com.poly.edu.project.graduation.services.UserService;

@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public Page<UserEntity> findByKeyWord(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findByKeyWord(keyword,pageable);
	}
	@Override
	public void changeStatusIsdeleted(long id) {
		userRepository.changeStatusIsdeleted(id);
	}

}
