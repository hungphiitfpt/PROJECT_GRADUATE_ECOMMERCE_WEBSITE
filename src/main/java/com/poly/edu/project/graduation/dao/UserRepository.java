package com.poly.edu.project.graduation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
	UserEntity findByUsername(String username);

	@Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
	Boolean existsByUsername(String username);
	
	@Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
	Boolean existsByEmail(String email);


}
