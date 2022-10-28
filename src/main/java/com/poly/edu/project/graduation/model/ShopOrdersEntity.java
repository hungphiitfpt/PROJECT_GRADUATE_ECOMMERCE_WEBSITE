package com.poly.edu.project.graduation.model;

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
    @UpdateTimestamp
    @Column(name = "order_date", nullable = true)
    private Timestamp orderDate;
    @Basic
    @Column(name = "shipped_date", nullable = true)
    private Timestamp shippedDate;
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
    @Column(name = "order_status", nullable = true, length = 50)
    private Integer orderStatus;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    
    @Basic
    @Column(name = "total_price", nullable = true, length = 50)
    private Long totalPrice;
    
    
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    
    @OneToMany(mappedBy = "shopOrdersByOrderId")
    private List<ShopOrderDetailEntity> shopOrderDetailsById;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserEntity userEntity;

    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopPaymentTypesEntity shopPaymentTypesByPaymentTypeId;

    
    public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

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

    public Timestamp getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Timestamp shippedDate) {
        this.shippedDate = shippedDate;
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


    public List<ShopOrderDetailEntity> getShopOrderDetailsById() {
        return shopOrderDetailsById;
    }

    public void setShopOrderDetailsById(List<ShopOrderDetailEntity> shopOrderDetailsById) {
        this.shopOrderDetailsById = shopOrderDetailsById;
    }



    public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public ShopPaymentTypesEntity getShopPaymentTypesByPaymentTypeId() {
        return shopPaymentTypesByPaymentTypeId;
    }

    public void setShopPaymentTypesByPaymentTypeId(ShopPaymentTypesEntity shopPaymentTypesByPaymentTypeId) {
        this.shopPaymentTypesByPaymentTypeId = shopPaymentTypesByPaymentTypeId;
    }
}
