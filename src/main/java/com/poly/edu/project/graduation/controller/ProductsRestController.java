package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.ProductsRepository;
import com.poly.edu.project.graduation.model.ShopProductsEntity;
import com.poly.edu.project.graduation.services.ProductServices;


@RestController
@RequestMapping("/api/graduation")
public class ProductsRestController {
	@Autowired
	ProductServices productServices;
	@Autowired
	ProductsRepository productsRepository;

	@RequestMapping("getListProduct")
	public List<ShopProductsEntity> getAllProduct() throws Exception {
		try {
			 
			List<ShopProductsEntity> dataProduct = productsRepository.findAll();
			return dataProduct;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ShopProductsEntity> findListProductByKey(@Param("keyword") String keyword) throws Exception {
		try {
			List<ShopProductsEntity> dataProduct = productServices.findByKeyWord(keyword);
			return dataProduct;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

//	
//	@RequestMapping("report/Product")
//	public List<ShopProductsEntity> getReportProduct() {
//		try {
//			 
//			List<ShopProductsEntity> dataProduct = dao.getReport();
//			return dataProduct;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	 
//	@PostMapping("delete/{id}")
//	ResponseEntity<ResponseObject> deleteProductById(@PathVariable int id, Model model) {
//		boolean exitsProduct = productsRepository.existsById(id);
//		if (exitsProduct) {
//			try {
//				productServices.deleteProductById(id);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Xoá Thành Công", null));
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Xoá thất bại", null));
//	}
//	@PostMapping("add")
//	ResponseEntity<ResponseObject> addProducts(@RequestBody ProductsEntity product, Model model) {
//		try {
//			productServices.saveProduct(product);
//			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Thêm Mới Thành Công", getAllProduct()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Xoá thất bại", null));
//	}

//	@PostMapping("update/{id}")
//	ResponseEntity<ResponseObject> updateProductById(@RequestBody ProductEntity prd, @PathVariable int id) {
//		try {
//			ProductEntity updatedProduct = productsRepository.findById(id).map(product -> {
//				product.setCategory(prd.getCategory());
//				product.setName(prd.getName());
//				product.setSize(prd.getSize());
//				product.setImage(prd.getImage());
//				product.setColor(prd.getColor());
//				product.setPrice(prd.getPrice());
//				return productsRepository.save(product);
//			}).orElseGet(() -> {
//				prd.setIdproduct(id);
//				return productsRepository.save(prd);
//			});
//			return ResponseEntity.status(HttpStatus.OK)
//					.body(new ResponseObject("ok", "Cập nhật thành công", null));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body(new ResponseObject("failed", "Cập nhật thất bại", null));
//		}
//
//	}
//	
//	@GetMapping("testapi")
//	public Page<ProductsEntity> testapi( @RequestParam("category") String category,
//			@RequestParam("name") String name, 
//			@RequestParam("sizeProduct") String sizeProduct,
//			@RequestParam("color") String color,
//			@RequestParam("price") String price 
//			) {
//		return productsRepository.findAllcate(category,name,sizeProduct,color,price, PageRequest.of(0, 100));
//		
//	}
//	

}
