package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Double rating;
	@Basic
	@Column(name = "comment", nullable = true, length = 200)
	private String comment;
	@Basic
	@Column(name = "created_at", nullable = true)
	private Timestamp createdAt;
	@Basic
	@Column(name = "updated_at", nullable = true)
	private Timestamp updatedAt;
	@Basic
	@Column(name = "is_deleted", nullable = true)
	private Boolean isDeleted;
	
	@Basic
	@Column(name = "last_name", nullable = true)
	private String lastName;



	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ShopProductsEntity shopProductsByProductId;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ShopCustomerEntity shopProductReviewsByIdCustomer;



	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ShopProductReviewsEntity that = (ShopProductReviewsEntity) o;

		if (id != that.id)
			return false;
		if (productId != null ? !productId.equals(that.productId) : that.productId != null)
			return false;
		if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null)
			return false;
		if (rating != null ? !rating.equals(that.rating) : that.rating != null)
			return false;
		if (comment != null ? !comment.equals(that.comment) : that.comment != null)
			return false;
		if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null)
			return false;
		if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null)
			return false;
		if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (productId != null ? productId.hashCode() : 0);
		result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
		result = 31 * result + (rating != null ? rating.hashCode() : 0);
		result = 31 * result + (comment != null ? comment.hashCode() : 0);
		result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
		result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
		result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
		return result;
	}

	public ShopProductsEntity getShopProductsByProductId() {
		return shopProductsByProductId;
	}

	public void setShopProductsByProductId(ShopProductsEntity shopProductsByProductId) {
		this.shopProductsByProductId = shopProductsByProductId;
	}
}
