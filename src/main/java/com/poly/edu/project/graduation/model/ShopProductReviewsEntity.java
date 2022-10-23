package com.poly.edu.project.graduation.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

//	@JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private UserEntity userByCustomerId;
	
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserEntity UserReviewProduct;


	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

    public void setRating(Integer rating) {
        this.rating = rating;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProductReviewsEntity that = (ShopProductReviewsEntity) o;

        if (id != that.id) return false;
        if (rating != that.rating) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

	public UserEntity getUserReviewProduct() {
		return UserReviewProduct;
	}

	public void setUserReviewProduct(UserEntity userReviewProduct) {
		UserReviewProduct = userReviewProduct;
	}



    

}
