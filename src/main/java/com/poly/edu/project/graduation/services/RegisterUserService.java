package com.poly.edu.project.graduation.services;

import org.springframework.stereotype.Service;

@Service
public interface RegisterUserService {

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
