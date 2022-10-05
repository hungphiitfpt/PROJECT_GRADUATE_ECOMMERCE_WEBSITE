package com.poly.edu.project.graduation.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shop_categories", schema = "ecommer_db", catalog = "")
public class ShopCategoriesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private long id;
	@Basic
	@Column(name = "category_code", nullable = true, length = 50)
	private String categoryCode;
	@Basic
	@Column(name = "category_name", nullable = true, length = 50)
	private String categoryName;
	@Basic
	@Column(name = "description", nullable = true, length = 200)
	private String description;
	@Basic
	@Column(name = "image", nullable = true, length = 200)
	private String image;
	@Basic
	@Column(name = "created_at", nullable = true)
	private Timestamp createdAt;
	@Basic
	@Column(name = "updated_at", nullable = true)
	private Timestamp updatedAt;
	@Basic
	@Column(name = "is_deleted", nullable = true)
	private Boolean isDeleted;
	@OneToMany(mappedBy = "shopCategoriesByCategoryId")
	@JsonIgnore
	private List<ShopProductsEntity> shopProductsById;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public List<ShopProductsEntity> getShopProductsById() {
		return shopProductsById;
	}

	public void setShopProductsById(List<ShopProductsEntity> shopProductsById) {
		this.shopProductsById = shopProductsById;
	}
}
