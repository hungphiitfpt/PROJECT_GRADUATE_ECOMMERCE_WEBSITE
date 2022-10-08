package com.poly.edu.project.graduation.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.ProductServices;

@Repository
public class ProductServicesImpl implements ProductServices {

	@Autowired
	ProductsRepository productsRepository;

	@Override
	public ShopProductsEntity findProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopProductsEntity> findAllProducts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopProductsEntity saveProduct(ShopProductsEntity products) {
		
		return productsRepository.save(products);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShopProductsEntity> findAllProductSaleOff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ShopProductsEntity> findAllBy(String category, String name, String size, String color, String price,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopProductsEntity> findByProductName(String name) {
		// TODO Auto-generated method stub
		return productsRepository.findByName(name);
	}

	@Override
	public List<ShopProductsEntity> getAllProductTableManager() {
		// TODO Auto-generated method stub
		return productsRepository.findAll();
	}

	@Override
	public Page<ShopProductsEntity> findByKeyWord(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return productsRepository.findByKeyWord(keyword, pageable);
	}



//	@Override
//	public List<ShopProductsEntity> findAllProducts() throws Exception {
//		return productsRepository.findAll();
//	}
//
//	@Override
//	public ShopProductsEntity findProductById(Integer id) {
//		// TODO Auto-generated method stub
//		return productsRepository.findById(id).get();
//	}

//	@Override
//	public ProductsEntity findProductById(int id) {
	// TODO Auto-generated method stub
//		return productsRepository.findById(id);
//	}
//	@Override
//	public void deleteProductById(int id) {
//		// TODO Auto-generated method stub
//		productsRepository.deleteById(id);
//	}
//
//	@Override
//	public void saveProduct(ShopProductsEntity products) {
//
//		productsRepository.save(products);// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List<ShopProductsEntity> findAllProductSaleOff() {
//		// TODO Auto-generated method stub
//		return productsRepository.findAllProductSaleOff();
//	}
//
//	@Override
//	public Page<ShopProductsEntity> findAllBy(String category, String name, String size, String color, String price,
//			Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productsRepository.findAllBy(category, name, size, color, price, pageable);
//	}
//
//	@Override
//	public Page<ShopProductsEntity> findAllBy(String category, String name, String size, String color, String price,
//			Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
