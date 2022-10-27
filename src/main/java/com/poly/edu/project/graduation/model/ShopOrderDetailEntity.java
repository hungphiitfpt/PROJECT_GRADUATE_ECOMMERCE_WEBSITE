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
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "order_id", nullable = true)
    private Long orderId;
    @Basic
    @Column(name = "product_id", nullable = true)
    private Long productId;
    @Basic
    @Column(name = "quantity", nullable = true, precision = 4)
    private Integer quantity;
    
    @Basic
    @Column(name = "product_name", nullable = true, precision = 4)
    private String productName;
    
 
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
    @Column(name = "price", nullable = true, length = 50)
    private Long price;
    
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopOrdersEntity shopOrdersByOrderId;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopProductsEntity shopProductsByProductId;
    
    
    
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
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
