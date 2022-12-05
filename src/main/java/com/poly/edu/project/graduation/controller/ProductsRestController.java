	package com.poly.edu.project.graduation.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopProductReviewsEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.ProductServices;
import com.poly.edu.project.graduation.services.ReviewProductService;

@RestController
@RequestMapping("/api/graduation")
public class ProductsRestController {
	@Autowired
	ProductServices productServices;
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ReviewProductService reviewProductService;

	// api lấy tất cả sản phẩm search theo keyword nhập vào
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopProductsEntity> findListProductByKey(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		try {
			Page<ShopProductsEntity> dataProduct = productServices.findByKeyWord(keyword, PageRequest.of(page, size));
			
			return dataProduct;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// api lấy tất cả sản phẩm search theo keyword nhập vào
		@RequestMapping(value = "/findListProductExist", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		public Page<ShopProductsEntity> findListProductExist(
				@RequestParam(name = "priceStart", required = false, defaultValue = "0") String priceStart,
				@RequestParam(name = "priceEnd", required = false, defaultValue = "999999999") String priceEnd,
				@RequestParam(name = "idCategory", required = false, defaultValue = "") Long idCategory,
				@RequestParam(name = "size", required = false, defaultValue = "9") int size,
				@RequestParam(name = "page", required = false, defaultValue = "0") int page,
				@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
				@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
			try {
				if(idCategory == null) {
					Page<ShopProductsEntity> dataProduct = productServices.findByKeyWord(keyword, PageRequest.of(page, size));
					return dataProduct;
				}
					Page<ShopProductsEntity> dataProduct = productServices.findAllProductEnable(idCategory,priceStart,priceEnd, PageRequest.of(page, size));
					return dataProduct;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

	@RequestMapping(value = "/filterDataProduct", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopProductsEntity> filterDataProduct(
			@RequestParam(name = "priceStart", required = false, defaultValue = "0") String priceStart,
			@RequestParam(name = "priceEnd", required = false, defaultValue = "999999999") String priceEnd,
			@RequestParam(name = "idCategory", required = false, defaultValue = "") Long idCategory,
			@RequestParam(name = "size", required = false, defaultValue = "9") int size,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		try {
			Page<ShopProductsEntity> dataProduct = productServices.filterShop(idCategory, priceStart, priceEnd,
					PageRequest.of(page, size));
			return dataProduct;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Lấy chi tiết sản phẩm
	@RequestMapping(value = "/getProductById", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	// Let's return an object with: data, message, status
	ResponseEntity<ResponseObject> findById(@RequestParam(name = "id") Long id) {
		try {
			Optional<ShopProductsEntity> foundProduct = productsRepository.findById(id);
			return foundProduct.isPresent()
					? ResponseEntity.status(HttpStatus.OK)
							.body(new ResponseObject("ok", "Tìm sản phẩm thành công", foundProduct))
					: ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new ResponseObject("failed", "Cannot find product with id = " + id, ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/GetReviewProductById", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ShopProductReviewsEntity> getAllReviewProductById(@RequestParam("id") Long id) {
		return reviewProductService.findAllReviewProduct(id);

	}

	@RequestMapping(value = "/GetRanDomProductById", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ShopProductsEntity> getRandomProduct(@RequestParam("id") String id) {
		return productServices.findProductRandomById(id);
	}

}
