package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.model.ShopBlogsEntity;
import com.poly.edu.project.graduation.services.BlogService;

@RestController
@RequestMapping("api/admin")
public class BlogRestController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = "/getAllBlogShop", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ShopBlogsEntity> index() {
		
		return blogService.findAllBlog();
		
	}
	


}
