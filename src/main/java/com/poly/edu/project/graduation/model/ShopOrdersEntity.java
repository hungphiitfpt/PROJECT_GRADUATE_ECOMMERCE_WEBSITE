package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @Column(name = "employee_id", nullable = true)
    private Long employeeId;
    @Basic
    @Column(name = "customer_id", nullable = true)
    private Long customerId;
    @Basic
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
    @Column(name = "ship_country", nullable = true, length = 255)
    private String shipCountry;
    @Basic
    @Column(name = "shipping_fee", nullable = true, precision = 4)
    private BigDecimal shippingFee;
    @Basic
    @Column(name = "payment_type_id", nullable = true)
    private Long paymentTypeId;
    @Basic
    @Column(name = "paid_date", nullable = true)
    private Timestamp paidDate;
    @Basic
    @Column(name = "order_status", nullable = true, length = 50)
    private String orderStatus;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    
    @OneToMany(mappedBy = "shopOrdersByOrderId")
    private List<ShopOrderDetailEntity> shopOrderDetailsById;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
    private RoleUserEntity roleUserByEmployeeId;

    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopPaymentTypesEntity shopPaymentTypesByPaymentTypeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
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


    public List<ShopOrderDetailEntity> getShopOrderDetailsById() {
        return shopOrderDetailsById;
    }

    public void setShopOrderDetailsById(List<ShopOrderDetailEntity> shopOrderDetailsById) {
        this.shopOrderDetailsById = shopOrderDetailsById;
    }

    public RoleUserEntity getRoleUserByEmployeeId() {
        return roleUserByEmployeeId;
    }

    public void setRoleUserByEmployeeId(RoleUserEntity roleUserByEmployeeId) {
        this.roleUserByEmployeeId = roleUserByEmployeeId;
    }


    public ShopPaymentTypesEntity getShopPaymentTypesByPaymentTypeId() {
        return shopPaymentTypesByPaymentTypeId;
    }

    public void setShopPaymentTypesByPaymentTypeId(ShopPaymentTypesEntity shopPaymentTypesByPaymentTypeId) {
        this.shopPaymentTypesByPaymentTypeId = shopPaymentTypesByPaymentTypeId;
    }
}
