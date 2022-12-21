package com.poly.edu.project.graduation.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.CategoryRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopCategoriesEntity;
import com.poly.edu.project.graduation.services.CategoryServices;

//Tạo file CategoryRestController
@CrossOrigin("*")
//tiêm anotation RESTCONTROLLER để trả về dữ liệu json
@RestController
@RequestMapping("/api/graduation")
public class CategoryRestController {

	// Tiêm lớp CategoryServices đã tạo sẵn 
	@Autowired
	CategoryServices categoryServices;

	// Tiêm lớp CategoryRepository 
	@Autowired
	CategoryRepository categoryRepository;

	//	Viết api lấy danh sách các danh mục , tìm kiếm sản phẩm theo key word theo chữ cái (điều kiện “” thì lấy tất cả)
	//	Truyền param keyword, size, page, sort
	@RequestMapping(value = "/getCategory", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopCategoriesEntity> findListCategoryByKey(
			// param keyword là dữ liệu người dùng nhập vào để tìm kiếm
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			// param size là số record muốn lấy
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			// param size là số record muốn lấy
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			// DESC , ASC
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		// thực hiện đoạn code trong try catch nếu lỗi trả về dữ liệu null
		try {
			// Phương thức này được xử lý theo trình tự CategoryRepository tạo ra phương thức findByKeyWord,
			// sau đó categoryServiceImpl gọi phương thức findByKeyWord trong lớp CategoryRepository.
			// sau đó categoryServiceImpl implement categoryServices
			// tạo biến dataCategory để hứng dữ liệu từ phương thức findByKeyWord trả dữ liệu theo dạng page 
			// của lớp Repository
			
			// => TẠO RA BIẾN dataCategory để hứng data từ phương thức findByKeyWord , 
			Page<ShopCategoriesEntity> dataCategory = categoryServices.findByKeyWord(keyword,
					PageRequest.of(page, size));
//			trả về data dưới dạng list object
			return dataCategory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//trả về null
		return null;
	}

	//phương thức get lấy toàn bộ danh sách danh mục
	@GetMapping("/category/getAllCategory")
	public List<ShopCategoriesEntity> getAllCategory() {

		return categoryServices.findAll();

	}

	// Lấy chi tiết sản phẩm theo phương thức get
	@RequestMapping(value = "/getCategoryById", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	// Sử dụng lớp ResponseEntity có sẵn của spring boot trả về dữ liệu, truyền param id
	ResponseEntity<ResponseObject> findById(@RequestParam(name = "id") Long id) {
		try {
			// Sử dụng lớp Optional có sẵn của Java 8 để tìm kiếm id
			//tạo ra biến foundCategory để hứng dữ liệu từ phương thức findbyid của lớp categoryRepository
			Optional<ShopCategoriesEntity> foundCategory = categoryRepository.findById(id);
			// nếu tồn tại thì trả về đối tượng category đó
			return foundCategory.isPresent()
					? ResponseEntity.status(HttpStatus.OK)
							.body(new ResponseObject("ok", "Tìm sản phẩm thành công", foundCategory))
			// nếu không tồn tại trả về lỗi note found
					: ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new ResponseObject("failed", "Cannot find Category with id = " + id, ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// api thêm sản phẩm, kiểm tra nếu đã có sản phẩm trùng trên không được thêm
	@RequestMapping(value = "/insert_category", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional
	ResponseEntity<ResponseObject> insertProduct(@RequestBody ShopCategoriesEntity shopCategoriesEntity) {
		// Kiểm tra xem tên sản phẩm đó đã có trong database chưa
		List<ShopCategoriesEntity> foundCategory = categoryServices
				.findByProductName(shopCategoriesEntity.getCategoryName().trim());
		// nếu tìm thấy tên sản phẩm đã có trong database thì trả về lỗi đã có sản phẩm trùng
		if (foundCategory.size() > 0) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("failed", "Đã có sản phẩm trùng tên ", ""));
		}
        //ngược lại sẽ thực hiện thêm mới sản phẩm vào database, bằng cách truyền 1 đối tượng vào
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("200", "Thêm Thành Công ", categoryRepository.save(shopCategoriesEntity)));
	}

//	api cập nhật danh mục, phương thức post
	@RequestMapping(value = "/update_category", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional
	// Trả về dữ liệu dưới dạng ResponseEntity, cập nhật danh mục theo id danh mục
	ResponseEntity<ResponseObject> updateProdcut(@RequestBody ShopCategoriesEntity categorys, @Param("id") Long id)
			throws Exception {
		// tìm kiếm danh mục theo id nếu tìm thấy sẽ set lại các giá trị theo người dùng truyền vào
		ShopCategoriesEntity updatedCategory = categoryRepository.findById(id).map(category -> {
			category.setCategoryCode(categorys.getCategoryCode());
			category.setCategoryName(categorys.getCategoryName());
			category.setDescription(categorys.getDescription());
			category.setImage(categorys.getImage());
			// gọi hàm save nó sẽ tự hiểu là upadet thì tìm kiếm thấy ID
			return categoryRepository.save(category);
		}).orElseGet(() -> {
			// nếu không tìm thấy id đó thì tự động thêm mới
			categorys.setId(0);
			return categoryRepository.save(categorys);
		});
		// xử lý cập nhật danh mục đó mà trả về trạng trái OK 200
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Update Product successfully", updatedCategory));
	}
	
	// Phương thức cập nhật trạng thái tắt của danh mục , method post. Cập nhật theo id danh mục
	@RequestMapping(value = "/update_category/isdeleted", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateIsDeleted(@Param("id") long id) {
		// Phương thức này được xử lý theo trình tự CategoryRepository tạo ra phương thức changeStatusIsdeleted,
		// sau đó categoryServiceImpl gọi phương thức changeStatusIsdeleted trong lớp CategoryDao.
		// sau đó categoryServiceImpl implement categoryServices
		categoryServices.changeStatusIsdeleted(id);
	}
	
	// Phương thức cập nhật trạng thái bật của danh mục , method post. Cập nhật theo id danh mục
	@RequestMapping(value = "/update_category/in_stock", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	void updateInstock(@Param("id") long id) {
		// Phương thức này được xử lý theo trình tự CategoryRepository tạo ra phương thức changeStatusInstock,
		// sau đó categoryServiceImpl gọi phương thức changeStatusInstock trong lớp CategoryDao.
		// sau đó categoryServiceImpl implement categoryServices
		categoryServices.changeStatusInstock(id);
	}
}
