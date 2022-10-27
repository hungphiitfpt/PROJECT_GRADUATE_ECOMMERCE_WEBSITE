package com.poly.edu.project.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import groovyjarjarantlr4.v4.parse.ANTLRParser.range_return;

@Controller
public class BlogController {

	@RequestMapping("/blog")
	public String index() {
		
		return "shop-template/blog";
	}
}
