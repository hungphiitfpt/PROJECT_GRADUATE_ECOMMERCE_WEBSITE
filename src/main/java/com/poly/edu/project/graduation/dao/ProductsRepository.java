//package com.poly.edu.project.graduation.dao;
//
//import java.util.List;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.poly.edu.project.graduation.model.ShopProductsEntity;
//
//
//
//
//public interface ProductsRepository extends JpaRepository<ShopProductsEntity, Long> {
//	
////	 STORE PROCEDURE đã được viết sẵn trong mysql thay vì viết câu lệnh tại đây
////	@Query(value ="{CALL findAllProductSaleOff()}" ,nativeQuery = true)
////	@Query(value ="select * from shop_products" ,nativeQuery = true)
////	List<ShopProductsEntity> findAllProductSaleOff();
//
////	@Query(value ="SELECT * FROM products WHERE quantity > 0 AND category LIKE %% AND name LIKE %:name% AND size LIKE %% AND color LIKE %% AND price LIKE %%" ,nativeQuery = true)
////	Page<ProductsEntity> findAllBy(@Param("name") String name, Pageable pageable);
//	
//	// Câu lệnh search điều kiện số lượng tồn kho của sản phẩm lớn hơn 0 và tìm kiếm theo danh mục, tên, kích cỡ, màu sắc, giá tiền ....
////	@Query(value ="SELECT * FROM Product WHERE quantity > 0 AND category LIKE %:category% AND name LIKE %:name% AND size LIKE %:size% AND color LIKE %:color% AND price LIKE %:price%" ,nativeQuery = true)
////	Page<ProductEntity> findAllBy(@Param("category") String category, @Param("name") String name, @Param("size") String size, @Param("color") String color, @Param("price") String price, Pageable pageable);
//	
////	@Query(value ="{CALL getAllProduct()}" ,nativeQuery = true)
////	List<ProductDataModel> getAllProducts() throws Exception;
////	@Query(value ="select count(idproduct) from products where category = 1 union  select count(idproduct) from products where category = 2 union select count(idproduct) from products where category = 3 " ,nativeQuery = true)
////    List<ProductEntity> getReport();
//}
