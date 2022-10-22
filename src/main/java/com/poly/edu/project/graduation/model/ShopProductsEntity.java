package com.poly.edu.project.graduation.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shop_products", schema = "ecommer_db", catalog = "")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
                      allowGetters = true)
public class ShopProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    
    @Basic
    @Column(name = "product_code", nullable = true, length = 25)
    private String productCode;
    
    @Basic
    @Column(name = "product_name", nullable = true, length = 50)
    private String productName;
    
    @Basic
    @Column(name = "image", nullable = true, length = 200)
    private String image;
    
    @Basic
    @Column(name = "short_decription", nullable = true, length = 250)
    private String shortDecription;
    
    @Basic
    @Column(name = "decription", nullable = true, length = 500)
    private String decription;
    
    @Basic
    @Column(name = "stand_cost", nullable = true, precision = 4)
    private BigDecimal standCost;
    
    @Basic
    @Column(name = "list_price", nullable = true, precision = 4)
    private BigDecimal listPrice;
    
    @Basic
    @Column(name = "quantity_per_unit", nullable = true, length = 50)
    private String quantityPerUnit;
    
    @Basic
    @Column(name = "discountinued", nullable = true)
    private Byte discountinued;
    
    @Basic
    @Column(name = "is_featured", nullable = false)
    private boolean isFeatured;
    
    @Basic
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    
    @Basic
    @Column(name = "category_id", nullable = true)
    private Long categoryId;

    
    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    
//    @Basic
//    @Column(name = "category_name", nullable = true)
//    private String categoryName;
    
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductDiscountEntity> shopProductDiscountsById;
    
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductImageEntity> shopProductImagesById;
    
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductReviewsEntity> shopProductReviewsById;
    
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductVouchersEntity> shopProductVouchersById;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopCategoriesEntity shopCategoriesByCategoryId;
    

//    
//    @OneToMany(mappedBy = "shopProductsByProductId")
//    private List<ShopOrderDetailEntity> shopOrderDetailsById;
//    
//    

//    public List<ShopOrderDetailEntity> getShopOrderDetailsById() {
//		return shopOrderDetailsById;
//	}

//	public void setShopOrderDetailsById(List<ShopOrderDetailEntity> shopOrderDetailsById) {
//		this.shopOrderDetailsById = shopOrderDetailsById;
//	}

    
	public long getId() {
        return id;
    }

//    public String getCategoryName() {
//		return categoryName;
//	}
//
//	public void setCategoryName(String categoryName) {
//		this.categoryName = categoryName;
//	}

	public void setId(long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortDecription() {
        return shortDecription;
    }

    public void setShortDecription(String shortDecription) {
        this.shortDecription = shortDecription;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public BigDecimal getStandCost() {
        return standCost;
    }

    public void setStandCost(BigDecimal standCost) {
        this.standCost = standCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Byte getDiscountinued() {
        return discountinued;
    }

    public void setDiscountinued(Byte discountinued) {
        this.discountinued = discountinued;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public List<ShopProductDiscountEntity> getShopProductDiscountsById() {
        return shopProductDiscountsById;
    }

    public void setShopProductDiscountsById(List<ShopProductDiscountEntity> shopProductDiscountsById) {
        this.shopProductDiscountsById = shopProductDiscountsById;
    }

    public List<ShopProductImageEntity> getShopProductImagesById() {
        return shopProductImagesById;
    }

    public void setShopProductImagesById(List<ShopProductImageEntity> shopProductImagesById) {
        this.shopProductImagesById = shopProductImagesById;
    }

    public List<ShopProductReviewsEntity> getShopProductReviewsById() {
        return shopProductReviewsById;
    }

    public void setShopProductReviewsById(List<ShopProductReviewsEntity> shopProductReviewsById) {
        this.shopProductReviewsById = shopProductReviewsById;
    }

    public List<ShopProductVouchersEntity> getShopProductVouchersById() {
        return shopProductVouchersById;
    }

    public void setShopProductVouchersById(List<ShopProductVouchersEntity> shopProductVouchersById) {
        this.shopProductVouchersById = shopProductVouchersById;
    }

    public ShopCategoriesEntity getShopCategoriesByCategoryId() {
        return shopCategoriesByCategoryId;
    }

    public void setShopCategoriesByCategoryId(ShopCategoriesEntity shopCategoriesByCategoryId) {
        this.shopCategoriesByCategoryId = shopCategoriesByCategoryId;
    }


}