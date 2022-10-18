package com.poly.edu.project.graduation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.CategoryRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.services.CategoryServices;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class CategoryRestController {

	@Autowired
	CategoryServices categoryServices;

	@Autowired
	CategoryRepository categoryRepository;

	// api lấy tất cả sản phẩm search theo keyword nhập vào
	@RequestMapping(value = "/getCategory", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopCategoriesEntity> findListProductByKey(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		try {
			Page<ShopCategoriesEntity> dataCategory = categoryServices.findByKeyWord(keyword,
					PageRequest.of(page, size));
			return dataCategory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("category/getAllCategory")
	public List<ShopCategoriesEntity> getAllCategory() {

		return categoryServices.findAll();

	}

	// Lấy chi tiết sản phẩm
	@RequestMapping(value = "/getCategoryById", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	// Let's return an object with: data, message, status
	ResponseEntity<ResponseObject> findById(@RequestParam(name = "id") Long id) {
		try {
			Optional<ShopCategoriesEntity> foundCategory = categoryRepository.findById(id);
			return foundCategory.isPresent()
					? ResponseEntity.status(HttpStatus.OK)
							.body(new ResponseObject("ok", "Tìm sản phẩm thành công", foundCategory))
					: ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new ResponseObject("failed", "Cannot find Category with id = " + id, ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// api thêm sản phẩm, kiểm tra nếu đã có sản phẩm trùng trên không được thêm
	@RequestMapping(value = "/insert_category", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional
	ResponseEntity<ResponseObject> insertProduct(@RequestBody ShopCategoriesEntity shopCategoriesEntity) {
		List<ShopCategoriesEntity> foundCategory = categoryServices
				.findByProductName(shopCategoriesEntity.getCategoryName().trim());
		if (foundCategory.size() > 0) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("failed", "Đã có sản phẩm trùng tên ", ""));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("200", "Thêm Thành Công ", categoryRepository.save(shopCategoriesEntity)));
	}

	@RequestMapping(value = "/update_category", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional
	ResponseEntity<ResponseObject> updateProdcut(@RequestBody ShopCategoriesEntity categorys, @Param("id") Long id)
			throws Exception {
		ShopCategoriesEntity updatedCategory = categoryRepository.findById(id).map(category -> {
			category.setCategoryCode(categorys.getCategoryCode());
			category.setCategoryName(categorys.getCategoryName());
			category.setDescription(categorys.getDescription());
			category.setImage(categorys.getImage());
			return categoryRepository.save(category);
		}).orElseGet(() -> {
			categorys.setId(0);
			return categoryRepository.save(categorys);
		});
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Update Product successfully", updatedCategory));
	}
	
	@RequestMapping(value = "/update_category/isdeleted", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateIsDeleted(@Param("id") long id) {
		categoryServices.changeStatusIsdeleted(id);
	}
	
	@RequestMapping(value = "/update_category/in_stock", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateInstock(@Param("id") long id) {
		categoryServices.changeStatusInstock(id);
	}
}
