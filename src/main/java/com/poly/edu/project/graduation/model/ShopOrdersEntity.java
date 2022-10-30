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
@Table(name = "shop_orders", schema = "ecommer_db", catalog = "")
public class ShopOrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Long userId;
    @Basic
    @Column(name = "order_date", nullable = true)
    private Timestamp orderDate;
    @Basic
    @Column(name = "ship_name", nullable = true, length = 50)
    private String shipName;
    @Basic
    @Column(name = "ship_address", nullable = true, length = 500)
    private String shipAddress;
    @Basic
    @Column(name = "ship_city", nullable = true, length = 255)
    private String shipCity;
    @Basic
    @Column(name = "ship_state", nullable = true, length = 255)
    private String shipState;
    @Basic
    @Column(name = "shipping_fee", nullable = true, precision = 4)
    private Integer shippingFee;
    @Basic
    @Column(name = "payment_type_id", nullable = true)
    private Long paymentTypeId;
    @Basic
    @Column(name = "paid_date", nullable = true)
    private Timestamp paidDate;
    @Basic
    @Column(name = "order_status", nullable = true)
    private Integer orderStatus;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "total_price", nullable = true)
    private Integer totalPrice;
    @Basic
    @Column(name = "shipped_date", nullable = true)
    private Timestamp shippedDate;
    @OneToMany(mappedBy = "shopOrdersByOrderId")
    private List<ShopOrderDetailEntity> shopOrderDetailsById;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private AppUserEntity appUserByUserId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopPaymentTypesEntity shopPaymentTypesByPaymentTypeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public Integer getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Integer shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Timestamp getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Timestamp paidDate) {
        this.paidDate = paidDate;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Timestamp shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopOrdersEntity that = (ShopOrdersEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (shipName != null ? !shipName.equals(that.shipName) : that.shipName != null) return false;
        if (shipAddress != null ? !shipAddress.equals(that.shipAddress) : that.shipAddress != null) return false;
        if (shipCity != null ? !shipCity.equals(that.shipCity) : that.shipCity != null) return false;
        if (shipState != null ? !shipState.equals(that.shipState) : that.shipState != null) return false;
        if (shippingFee != null ? !shippingFee.equals(that.shippingFee) : that.shippingFee != null) return false;
        if (paymentTypeId != null ? !paymentTypeId.equals(that.paymentTypeId) : that.paymentTypeId != null)
            return false;
        if (paidDate != null ? !paidDate.equals(that.paidDate) : that.paidDate != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (shippedDate != null ? !shippedDate.equals(that.shippedDate) : that.shippedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (shipName != null ? shipName.hashCode() : 0);
        result = 31 * result + (shipAddress != null ? shipAddress.hashCode() : 0);
        result = 31 * result + (shipCity != null ? shipCity.hashCode() : 0);
        result = 31 * result + (shipState != null ? shipState.hashCode() : 0);
        result = 31 * result + (shippingFee != null ? shippingFee.hashCode() : 0);
        result = 31 * result + (paymentTypeId != null ? paymentTypeId.hashCode() : 0);
        result = 31 * result + (paidDate != null ? paidDate.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        return result;
    }

    public List<ShopOrderDetailEntity> getShopOrderDetailsById() {
        return shopOrderDetailsById;
    }

    public void setShopOrderDetailsById(List<ShopOrderDetailEntity> shopOrderDetailsById) {
        this.shopOrderDetailsById = shopOrderDetailsById;
    }

    public AppUserEntity getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUserEntity appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
    }

    public ShopPaymentTypesEntity getShopPaymentTypesByPaymentTypeId() {
        return shopPaymentTypesByPaymentTypeId;
    }

    public void setShopPaymentTypesByPaymentTypeId(ShopPaymentTypesEntity shopPaymentTypesByPaymentTypeId) {
        this.shopPaymentTypesByPaymentTypeId = shopPaymentTypesByPaymentTypeId;
    }
}
