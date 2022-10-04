package com.poly.edu.project.graduation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.ShopSuplierEntity;

public interface SupplierRepository extends JpaRepository<ShopSuplierEntity, Long> {

	@Query(value = "SELECT c.id, c.supplier_code, c.image, c.supplier_name "
				 + "FROM shop_suplier as c WHERE is_deleted = false", nativeQuery = true)
	List<ShopSuplierEntity> findAllSupplier();

}