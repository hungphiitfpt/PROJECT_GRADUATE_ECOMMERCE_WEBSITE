package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "shop_order_detail", schema = "ecommer_db", catalog = "")
public class ShopOrderDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "order_id", nullable = true)
    private Long orderId;
    @Basic
    @Column(name = "product_id", nullable = true)
    private Long productId;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "discount_percentage", nullable = true, precision = 0)
    private Double discountPercentage;
    @Basic
    @Column(name = "discount_amount", nullable = true, precision = 0)
    private Double discountAmount;
    @Basic
    @Column(name = "order_detail_status", nullable = true, length = 50)
    private String orderDetailStatus;
    @Basic
    @Column(name = "date_allocated", nullable = true)
    private Timestamp dateAllocated;
    @Basic
    @Column(name = "price", nullable = true, precision = 4)
    private Integer price;
    @Basic
    @Column(name = "product_name", nullable = true, length = 50)
    private String productName;
    @Basic
    @Column(name = "ship_date", nullable = true)
    private Timestamp shipDate;
    @Basic
    @Column(name = "image", nullable = true, length = 500)
    private String image;
    @Basic
    @Column(name = "category", nullable = true, length = 500)
    private String category;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopOrdersEntity shopOrdersByOrderId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopProductsEntity shopProductsByProductId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopCategoriesEntity shopOrderDetailByCategoryId;

    
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ShopCategoriesEntity getShopOrderDetailByCategoryId() {
		return shopOrderDetailByCategoryId;
	}

	public void setShopOrderDetailByCategoryId(ShopCategoriesEntity shopOrderDetailByCategoryId) {
		this.shopOrderDetailByCategoryId = shopOrderDetailByCategoryId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ShopOrdersEntity getShopOrdersByOrderId() {
        return shopOrdersByOrderId;
    }

    public void setShopOrdersByOrderId(ShopOrdersEntity shopOrdersByOrderId) {
        this.shopOrdersByOrderId = shopOrdersByOrderId;
    }

    public ShopProductsEntity getShopProductsByProductId() {
        return shopProductsByProductId;
    }

    public void setShopProductsByProductId(ShopProductsEntity shopProductsByProductId) {
        this.shopProductsByProductId = shopProductsByProductId;
    }
}
