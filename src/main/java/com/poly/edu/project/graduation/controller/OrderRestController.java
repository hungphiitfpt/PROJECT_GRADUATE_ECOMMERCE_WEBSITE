package com.poly.edu.project.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.OrderRepository;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.services.OrderService;

// tiêm anostation @RestController
@RestController
// điều hướng request api
@RequestMapping("api/admin")
//đầu tiên tạo file OrderRestController
public class OrderRestController {

	// tiêm lớp orderRepository
	@Autowired
	OrderRepository orderRepository;
	
	// tiêm lớp orderService
	@Autowired
	OrderService orderService;

	// API lấy danh sách đơn hàng theo tên khách hàng
	@RequestMapping(value = "/getOrderProducts", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Page<ShopOrdersEntity> index(
			//keyword là dữ liệu người dùng muốn nhập, nếu không truyền mặc định truyền rỗng sẽ lấy tất cả
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			//size là số record lấy người dùng muốn trả về
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			// page là số thứ tự của trang
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			// sort là sắp xếp trang theo giảm dần và tăng dần
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) throws Exception {
		// tạo 1 biến kiểu LIST OBJECT để hứng data từ phương thức findByKeyWord của lớp interface orderService
		Page<ShopOrdersEntity> dataOrders = orderService.findByKeyWord(keyword, PageRequest.of(page, size));
		return dataOrders;
	}

	// API Thay đổi trạng thái của đơn hàng method post
	@RequestMapping(value = "/changeStatusOrders", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void changeStatusOrders(
			// status là param trạng thái đơn hàng
			@RequestParam(name = "status", required = false, defaultValue = "") Long status,
			// update_at là ngày thay đổi trạng thái đơn hàng
			@RequestParam(name = "update_at", required = false) String update_at,
			// shipped_date là ngày giao hàng xong
			@RequestParam(name = "shipped_date", required = false) String shipped_date,
			// id là id đơn hàng
			@RequestParam(name = "id", required = false, defaultValue = "") Long id) {
		try {
			orderRepository.changeStatusOrder(status, update_at, shipped_date, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/countUserOrderDateNow", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String countOrdersDateNow() {
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String numberOrders = orderService.countNumberOrders(date);
			return numberOrders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/TotalPriceOrderDateNow", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String TotalPriceOrderDateNow() {
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String totalPriceOrders = orderService.totalPriceOrdersDateNow(date);
			return totalPriceOrders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/CountOrdersDateNow", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String CountUsersOrders() {
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String totalPriceOrders = orderService.CountOrdersDateNow(date);
			return totalPriceOrders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/marqueeCountOrder", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<String> marqueeCountOrder() {
		return orderService.CountMarqueeOrder();
	}
}
