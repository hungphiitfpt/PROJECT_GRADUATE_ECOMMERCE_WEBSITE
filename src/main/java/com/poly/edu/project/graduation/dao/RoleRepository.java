package com.poly.edu.project.graduation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.edu.project.graduation.model.AppRoleEntity;


public interface RoleRepository extends JpaRepository<AppRoleEntity, Integer> {

//	AppRoleEntity findByName(String string);

}
