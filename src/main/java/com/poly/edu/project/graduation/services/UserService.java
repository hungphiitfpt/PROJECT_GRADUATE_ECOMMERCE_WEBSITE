package com.poly.edu.project.graduation.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.model.UserEntity;

@Service
public interface UserService {

	Page<UserEntity> findByKeyWord(String keyword, Pageable pageable);

	void changeStatusIsdeleted(long id);

	void changeStatusInstock(long id);

}