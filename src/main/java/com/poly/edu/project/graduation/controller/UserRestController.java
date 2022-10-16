package com.poly.edu.project.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.model.UserEntity;
import com.poly.edu.project.graduation.services.UserService;

@RestController
@RequestMapping("/api/admin")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	
	// api lấy tất cả sản phẩm search theo keyword nhập vào
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Page<UserEntity> findListProductByKey(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		try {
			Page<UserEntity> dataUsers = userService.findByKeyWord(keyword, PageRequest.of(page, size));
			return dataUsers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/updateUser/isdeleted", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateIsDeleted(@Param("id") long id) {
		userService.changeStatusIsdeleted(id);
	}
	
	@RequestMapping(value = "/updateUser/in_stock", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateInstock(@Param("id") long id) {
		userService.changeStatusInstock(id);
	}
	
}
