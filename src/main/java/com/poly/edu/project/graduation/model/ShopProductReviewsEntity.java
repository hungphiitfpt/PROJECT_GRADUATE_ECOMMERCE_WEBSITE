package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "shop_product_reviews", schema = "ecommer_db", catalog = "")
public class ShopProductReviewsEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	
	@Basic
	@Column(name = "product_id", nullable = true)
	private Long productId;
	
	@Basic
	@Column(name = "customer_id", nullable = true)
	private Long customerId;
	
	@Basic
	@Column(name = "rating", nullable = true, precision = 0)
	private int rating;
	
	@Basic
	@Column(name = "comment", nullable = true, length = 200)
	private String comment;
	
	@Basic
	@CreationTimestamp
	@Column(name = "created_at", nullable = true)
	private Timestamp createdAt;
	
	@Basic
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = true)
	private Timestamp updatedAt;
	
	@Basic
	@Column(name = "is_deleted", nullable = true)
	private Boolean isDeleted;

	@JsonIgnore
	@ManyToOne
//	@JsonBackReference
	@JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ShopProductsEntity shopProductsByProductId;
	@JsonIgnore
	@ManyToOne
//	@JsonBackReference
	@JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ShopCustomerEntity shopProductReviewsByIdCustomer;


	public ShopCustomerEntity getShopProductReviewsByIdCustomer() {
		return shopProductReviewsByIdCustomer;
	}

	public void setShopProductReviewsByIdCustomer(ShopCustomerEntity shopProductReviewsByIdCustomer) {
		this.shopProductReviewsByIdCustomer = shopProductReviewsByIdCustomer;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}
	

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public ShopProductsEntity getShopProductsByProductId() {
		return shopProductsByProductId;
	}

	public void setShopProductsByProductId(ShopProductsEntity shopProductsByProductId) {
		this.shopProductsByProductId = shopProductsByProductId;
	}
}
