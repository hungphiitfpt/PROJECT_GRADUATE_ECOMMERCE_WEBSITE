package com.poly.edu.project.graduation.model;

import java.sql.Timestamp;

public class CartEntity {

	private Long id;

	private Long orderId;

	private Long productId;

	private Integer quantity;

	private String productName;

	private Double discountPercentage;

	private Double discountAmount;

	private String orderDetailStatus;

	private Timestamp dateAllocated;

	private Integer price;
	
	private Long payment_type_id;
	
	private Integer shippingFee;
	 
	private String image;
	
	

	
	public Integer getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Long getPayment_type_id() {
		return payment_type_id;
	}

	public void setPayment_type_id(Long payment_type_id) {
		this.payment_type_id = payment_type_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getOrderDetailStatus() {
		return orderDetailStatus;
	}

	public void setOrderDetailStatus(String orderDetailStatus) {
		this.orderDetailStatus = orderDetailStatus;
	}

	public Timestamp getDateAllocated() {
		return dateAllocated;
	}

	public void setDateAllocated(Timestamp dateAllocated) {
		this.dateAllocated = dateAllocated;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
