package com.poly.edu.project.graduation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.BlogRepository;
import com.poly.edu.project.graduation.model.ShopBlogsEntity;
import com.poly.edu.project.graduation.services.BlogService;

@Repository
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogRepository blogRepository;

	@Override
	public List<ShopBlogsEntity> findAllBlog() {
		// TODO Auto-generated method stub
		return blogRepository.findAllBlogShop();
	}

	@Override
	public ShopBlogsEntity findBlogDetailById(Long id) {
		// TODO Auto-generated method stub
		return blogRepository.findById(id);
	}



}
