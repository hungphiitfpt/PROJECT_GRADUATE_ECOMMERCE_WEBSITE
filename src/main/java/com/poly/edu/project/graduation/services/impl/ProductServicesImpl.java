package com.poly.edu.project.graduation.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.Products;
import com.poly.edu.project.graduation.services.ProductServices;

@Repository
public class ProductServicesImpl implements ProductServices {
@Autowired
ProductsRepository productsRepository;
	@Override
	public List<Products> findAllProducts() {
		return productsRepository.findAll();
	}
	@Override
	public Optional<Products> findProductById(int id) {
		// TODO Auto-generated method stub
		return productsRepository.findById(id);
	}
	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productsRepository.deleteById(id);
	}
	@Override
	public void saveProduct(Products products) {
		
		productsRepository.save(products);// TODO Auto-generated method stub
		
	}




}
 