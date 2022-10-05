package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "shop_suplier", schema = "ecommer_db", catalog = "")
public class ShopSuplierEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private long id;
	@Basic
	@Column(name = "supplier_code", nullable = true, length = 50)
	private String supplierCode;
	@Basic
	@Column(name = "supplier_name", nullable = true, length = 200)
	private String supplierName;
	@Basic
	@Column(name = "description", nullable = true, length = 500)
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
	@OneToMany(mappedBy = "shopSuplierBySupplierId")
	@JsonIgnore
	private List<ShopProductsEntity> shopProductsById;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
