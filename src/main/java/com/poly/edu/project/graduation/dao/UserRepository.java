//package com.poly.edu.project.graduation.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.poly.edu.project.graduation.model.UsersEntity;
//
//public interface UserRepository extends JpaRepository<UsersEntity, Long> {
//
//	@Query("SELECT u FROM UsersEntity u WHERE u.email = ?1")
//	UsersEntity findByUsername(String username);
//
//	@Query("SELECT u FROM UsersEntity u WHERE u.username = ?1")
//	Boolean existsByUsername(String username);
//	
//	@Query("SELECT u FROM UsersEntity u WHERE u.email = ?1")
//	Boolean existsByEmail(String email);
//
//
//}
