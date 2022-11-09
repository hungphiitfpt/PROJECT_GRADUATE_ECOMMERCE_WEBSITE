package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.edu.project.graduation.model.ShopBlogsEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.BlogService;

@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;

	@RequestMapping("/blog")
	public String index() {
		return "shop-template/blog";
	}
	
	@RequestMapping("/blogDetail")
	public String blogDetails() {
		
		return "shop-template/blog-details";
	}
	@RequestMapping(value = "/BlogDetails", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public String getBlogDetailById(@RequestParam("id") Long id, Model model) {
		ShopBlogsEntity blog = blogService.findBlogDetailById(id);
		model.addAttribute("blog", blog);
		System.out.println(blog);
		return "shop-template/blog-details";
		
	}
	@RequestMapping("/loveYou")
	public String hearth() {
		
		return "hearth";
	}
}
