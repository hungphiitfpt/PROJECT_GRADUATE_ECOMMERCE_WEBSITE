package com.poly.edu.project.graduation.services.impl;

import java.util.List;
import java.util.Optional;

import com.poly.edu.project.graduation.model.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.services.ProductServices;

@Repository
public class ProductServicesImpl implements ProductServices {
	
@Autowired
ProductsRepository productsRepository;

	@Override
	public List<ProductsEntity> findAllProducts() {
		return productsRepository.findAll();
	}
	
	@Override
	public Optional<ProductsEntity> findProductById(int id) {
		// TODO Auto-generated method stub
		return productsRepository.findById(id);
	}
	
	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productsRepository.deleteById(id);
	}
	
	@Override
	public void saveProduct(ProductsEntity products) {
		
		productsRepository.save(products);// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<ProductsEntity> findAllProductSaleOff() {
		// TODO Auto-generated method stub
		return productsRepository.findAllProductSaleOff();
	}
	
	@Override
	public Page<ProductsEntity> findAllBy(String category, String name, String size, String color, String price, Pageable pageable) {
		// TODO Auto-generated method stub
		return productsRepository.findAllBy(category, name, size, color, price, pageable);
	}




}
 