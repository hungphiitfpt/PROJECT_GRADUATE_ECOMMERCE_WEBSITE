package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.model.ShopProductsEntity;

// lớp này sử dụng để giao tiếp với db
@Service
// lớp này sử dụng để tạo ra các phương thức 
public interface ProductServices {

	ShopProductsEntity findProductById(Integer id);

	List<ShopProductsEntity> findAllProducts() throws Exception;

	void saveProduct(ShopProductsEntity products);

	void deleteProductById(int id);

//	Optional<ProductsEntity> findProductById(int id);

	List<ShopProductsEntity> findAllProductSaleOff();

	Page<ShopProductsEntity> findAllBy(String category, String name, String size, String color, String price,
			Pageable pageable);

}
