package com.poly.edu.project.graduation.services;

import java.util.List;
import java.util.Optional;

import com.poly.edu.project.graduation.model.CategoryEntity;
import com.poly.edu.project.graduation.model.ProductsEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// lớp này sử dụng để giao tiếp với db
@Service
public interface CategoryServices {

	List<CategoryEntity> findAll();

}