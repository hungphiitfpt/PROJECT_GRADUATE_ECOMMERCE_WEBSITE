package com.poly.edu.project.graduation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.edu.project.graduation.model.ShopProductImageEntity;
import com.poly.edu.project.graduation.model.ShopProductsEntity;

@Repository
public interface ProductsRepository extends JpaRepository<ShopProductsEntity, Long> {
	// Câu lệnh query lấy tất cả sản phẩm theo tên sản phẩm
	@Query("SELECT u FROM ShopProductsEntity u WHERE u.productName = ?1")
	List<ShopProductsEntity> findByName(String name);
	
	// Câu lệnh tìm kiếm sản phẩm theo nhiều điều kiện

	@Query(value ="SELECT  * from shop_products where shop_products.is_deleted = false "
			+ "AND shop_products.id 				LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.product_code 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.product_name 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.list_price 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.discountinued 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.quantity_per_unit 	LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.category_id 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.created_at 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR shop_products.updated_at 			LIKE CONCAT('%',:keyword,'%') "
			 ,nativeQuery = true)
	Page<ShopProductsEntity> findByKeyWord(String keyword, Pageable pageable);
	
//	@Query(value= "SELECT p.id, p.product_code, p.product_name, "
//			+ "	   p.short_decription,p.decription,p.list_price, "
//			+ "    p.quantity_per_unit,p.discountinued,p.category_id, "
//			+ "	   p.created_at, p.updated_at, p.image,p.stand_cost, "
//			+ "	   p.is_featured,p.is_deleted,p.supplier_id, "
//			+ "	   c.category_name "
//			+ "FROM shop_products  as p  "
//			+ "LEFT JOIN shop_categories as c ON p.category_id = c.id where p.id = ?1 ",nativeQuery = true)
	ShopProductsEntity findProductById(Long id);
	
	@Query(value ="SELECT * FROM shop_products WHERE is_deleted = false "
			+ "and category_id = :idCategory ", nativeQuery = true)
	Page<ShopProductsEntity> findAll(@Param("idCategory") String idCategory, PageRequest pageRequest);
	
	@Query(value = "SELECT * FROM shop_products WHERE is_deleted = false AND category_id = ?1 "
			+ "ORDER BY RAND() LIMIT 4 ", nativeQuery = true)
	List<ShopProductsEntity> findProductRandomById(String idCategory);
	
	@Modifying  
	@Query(value = "UPDATE ShopProductsEntity SET isDeleted = TRUE WHERE id = ?1")
	@Transactional
	void changeStatusIsdeleted(long id);

	@Modifying  
	@Query(value = "UPDATE ShopProductsEntity SET isDeleted = FALSE WHERE id = ?1")
	@Transactional
	void changeIstock(long id);
	
	@Query(value ="SELECT * FROM shop_products where list_price BETWEEN :priceStart AND :priceEnd",nativeQuery = true)
	Page<ShopProductsEntity> filterShop( String priceStart, String priceEnd, Pageable pageable);
	
	@Query(value ="SELECT * FROM shop_products where list_price BETWEEN :priceStart AND :priceEnd AND category_id = :category_id",nativeQuery = true)
	Page<ShopProductsEntity> filterShopPriceAndCategory( String priceStart, String priceEnd,String category_id, Pageable pageable);

	@Query(value ="SELECT * FROM shop_products where category_id LIKE CONCAT('%',:idCategory,'%')",nativeQuery = true)
	Page<ShopProductsEntity> findAllProductEnable(Long idCategory, Pageable page);
	
	@Query(value ="SELECT * FROM shop_products where is_deleted = false",nativeQuery = true)
	Page<ShopProductsEntity> findProductEnable(Pageable page);
	
	@Modifying 
	@Query(value ="INSERT INTO shop_product_image (product_id,image) VALUES (:id,:image)",nativeQuery = true)
	@Transactional
	void uploadListImageById(Long id, String image);

}
