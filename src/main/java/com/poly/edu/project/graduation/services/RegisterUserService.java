package com.poly.edu.project.graduation.services;

import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.UserEntity;

@Service
public interface RegisterUserService {

	void save(UserEntity user);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
