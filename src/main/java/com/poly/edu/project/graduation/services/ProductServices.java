package com.poly.edu.project.graduation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

@Service
// lớp này sử dụng để tạo ra các phương thức 
public interface ProductServices {

	ShopProductsEntity findProductById(Integer id);

	Page<ShopProductsEntity> findAllProducts(String idCategory, PageRequest pageRequest) throws Exception;

	ShopProductsEntity saveProduct(ShopProductsEntity products);

	void deleteProductById(int id);

	List<ShopProductsEntity> findAllProductSaleOff();

	Page<ShopProductsEntity> findAllBy(String category, String name, String size, String color, String price,
			Pageable pageable);

	List<ShopProductsEntity> findByProductName(String trim);

	List<ShopProductsEntity> getAllProductTableManager();

	Page<ShopProductsEntity> findByKeyWord(String keyword, Pageable pageable);

	Optional<ShopCategoriesEntity> findAllCategory();

	List<ShopProductsEntity> findAllProductByCategoryId(Long idCategory);

	ShopProductsEntity findProductById(Long id);

	ShopProductsEntity findAllReviewProduct(Long id);

	void changeStatusIsdeleted(long id);

	List<ShopProductsEntity> findProductRandomById(String idCategory);

	void changeStatusInstock(long id);

	

}
