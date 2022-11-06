package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopBlogsEntity;

@Service
public interface BlogService {

	List<ShopBlogsEntity> findAllBlog();

	ShopBlogsEntity findBlogDetailById(Long id);

}
