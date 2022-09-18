package com.poly.edu.project.graduation.services.impl;

import java.util.List;
import java.util.Optional;

import com.poly.edu.project.graduation.model.CategoryEntity;
import com.poly.edu.project.graduation.model.ColorEntity;
import com.poly.edu.project.graduation.model.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.CategoryRepository;
import com.poly.edu.project.graduation.dao.ColorRepository;
import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.services.CategoryServices;
import com.poly.edu.project.graduation.services.ColorServices;
import com.poly.edu.project.graduation.services.ProductServices;

@Repository
public class ColorServicesImpl implements ColorServices {

	@Autowired
	ColorRepository colorRepository;

	@Override
	public List<ColorEntity> findAll() {
		// TODO Auto-generated method stub
		return colorRepository.findAll();
	}

}
