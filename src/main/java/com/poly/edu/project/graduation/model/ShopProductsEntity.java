package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "shop_products", schema = "ecommer_db", catalog = "")
public class ShopProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "product_code", nullable = false, length = 25)
    private String productCode;
    @Basic
    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;
    @Basic
    @Column(name = "image", nullable = false, length = 200)
    private String image;
    @Basic
    @Column(name = "short_decription", nullable = true, length = 250)
    private String shortDecription;
    @Basic
    @Column(name = "decription", nullable = true, length = 5000)
    private String decription;
    @Basic
    @Column(name = "stand_cost", nullable = true, precision = 4)
    private BigDecimal standCost;
    @Basic
    @Column(name = "list_price", nullable = false, precision = 4)
    private BigDecimal listPrice;
    @Basic
    @Column(name = "quantity_per_unit", nullable = false)
    private int quantityPerUnit;
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
    @Column(name = "category_id", nullable = false)
    private long categoryId;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    
    @Column(name = "quantity_sold", nullable = false)
    private Integer quantity_sold;
    
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopOrderDetailEntity> shopOrderDetailsById;
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductDiscountEntity> shopProductDiscountsById;
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductImageEntity> shopProductImagesById;
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductReviewsEntity> shopProductReviewsById;
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopProductVouchersEntity> shopProductVouchersById;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private ShopCategoriesEntity shopCategoriesByCategoryId;
    @OneToMany(mappedBy = "shopProductsByProductId")
    private List<ShopWarehouseEntity> shopWarehousesById;
    

    public Integer getQuantity_sold() {
		return quantity_sold;
	}

	public void setQuantity_sold(Integer quantity_sold) {
		this.quantity_sold = quantity_sold;
	}

	public long getId() {
        return id;
    }

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

    public int getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProductsEntity that = (ShopProductsEntity) o;

        if (id != that.id) return false;
        if (quantityPerUnit != that.quantityPerUnit) return false;
        if (isFeatured != that.isFeatured) return false;
        if (isDeleted != that.isDeleted) return false;
        if (categoryId != that.categoryId) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (shortDecription != null ? !shortDecription.equals(that.shortDecription) : that.shortDecription != null)
            return false;
        if (decription != null ? !decription.equals(that.decription) : that.decription != null) return false;
        if (standCost != null ? !standCost.equals(that.standCost) : that.standCost != null) return false;
        if (listPrice != null ? !listPrice.equals(that.listPrice) : that.listPrice != null) return false;
        if (discountinued != null ? !discountinued.equals(that.discountinued) : that.discountinued != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (shortDecription != null ? shortDecription.hashCode() : 0);
        result = 31 * result + (decription != null ? decription.hashCode() : 0);
        result = 31 * result + (standCost != null ? standCost.hashCode() : 0);
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        result = 31 * result + quantityPerUnit;
        result = 31 * result + (discountinued != null ? discountinued.hashCode() : 0);
        result = 31 * result + (isFeatured ? 1 : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (int) (categoryId ^ (categoryId >>> 32));
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public List<ShopOrderDetailEntity> getShopOrderDetailsById() {
        return shopOrderDetailsById;
    }

    public void setShopOrderDetailsById(List<ShopOrderDetailEntity> shopOrderDetailsById) {
        this.shopOrderDetailsById = shopOrderDetailsById;
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

    public List<ShopWarehouseEntity> getShopWarehousesById() {
        return shopWarehousesById;
    }

    public void setShopWarehousesById(List<ShopWarehouseEntity> shopWarehousesById) {
        this.shopWarehousesById = shopWarehousesById;
    }
}
