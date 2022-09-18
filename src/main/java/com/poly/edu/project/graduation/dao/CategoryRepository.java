package com.poly.edu.project.graduation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.edu.project.graduation.model.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
