package com.poly.edu.project.graduation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.edu.project.graduation.dao.OrderRepository;
import com.poly.edu.project.graduation.model.ResponseObject;
import com.poly.edu.project.graduation.model.ShopOrdersEntity;
import com.poly.edu.project.graduation.services.OrderService;

@RestController
@RequestMapping("api/admin")
public class OrderDetailRestController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping(value = "/getOrderDetail", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    //truyền vào param id của đơn hàng
	public ResponseEntity<ResponseObject> getOrderDetail(@RequestParam(name = "id", required = false, defaultValue = "") Long id) {
		try {
			// tạo biến foundProduct list object để hứng dữ liệu về phương thức findById trả về
			Optional<ShopOrdersEntity> foundProduct = orderRepository.findById(id);
			// sau khi trả về
			// nếu tìm thấy đơn hàng trả dữ liệu về với trạng thái 200 + data
			return foundProduct.isPresent()
					? ResponseEntity.status(HttpStatus.OK)
							.body(new ResponseObject("ok", "Tìm phiếu đơn hàng chi tiết thành công", foundProduct))
			// nếu tìm thấy đơn hàng trả dữ liệu về với trạng thái NOT_FOUND
					: ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new ResponseObject("failed", "Không thể tìm thấy phiếu hàng order id = " + id, ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
