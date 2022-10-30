package com.poly.edu.project.graduation.model;

import javax.persistence.*;

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
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopOrdersEntity shopOrdersByOrderId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopProductsEntity shopProductsByProductId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopOrderDetailEntity that = (ShopOrderDetailEntity) o;

        if (id != that.id) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (discountPercentage != null ? !discountPercentage.equals(that.discountPercentage) : that.discountPercentage != null)
            return false;
        if (discountAmount != null ? !discountAmount.equals(that.discountAmount) : that.discountAmount != null)
            return false;
        if (orderDetailStatus != null ? !orderDetailStatus.equals(that.orderDetailStatus) : that.orderDetailStatus != null)
            return false;
        if (dateAllocated != null ? !dateAllocated.equals(that.dateAllocated) : that.dateAllocated != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (shipDate != null ? !shipDate.equals(that.shipDate) : that.shipDate != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (discountPercentage != null ? discountPercentage.hashCode() : 0);
        result = 31 * result + (discountAmount != null ? discountAmount.hashCode() : 0);
        result = 31 * result + (orderDetailStatus != null ? orderDetailStatus.hashCode() : 0);
        result = 31 * result + (dateAllocated != null ? dateAllocated.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (shipDate != null ? shipDate.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
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
