package com.poly.edu.project.graduation.model;

import javax.persistence.*;

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
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    
    @Basic
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
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopCustomerEntity shopCustomerByCustomerId;
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopOrdersEntity that = (ShopOrdersEntity) o;

        if (id != that.id) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (shippedDate != null ? !shippedDate.equals(that.shippedDate) : that.shippedDate != null) return false;
        if (shipName != null ? !shipName.equals(that.shipName) : that.shipName != null) return false;
        if (shipAddress != null ? !shipAddress.equals(that.shipAddress) : that.shipAddress != null) return false;
        if (shipCity != null ? !shipCity.equals(that.shipCity) : that.shipCity != null) return false;
        if (shipState != null ? !shipState.equals(that.shipState) : that.shipState != null) return false;
        if (shipCountry != null ? !shipCountry.equals(that.shipCountry) : that.shipCountry != null) return false;
        if (shippingFee != null ? !shippingFee.equals(that.shippingFee) : that.shippingFee != null) return false;
        if (paymentTypeId != null ? !paymentTypeId.equals(that.paymentTypeId) : that.paymentTypeId != null)
            return false;
        if (paidDate != null ? !paidDate.equals(that.paidDate) : that.paidDate != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        result = 31 * result + (shipName != null ? shipName.hashCode() : 0);
        result = 31 * result + (shipAddress != null ? shipAddress.hashCode() : 0);
        result = 31 * result + (shipCity != null ? shipCity.hashCode() : 0);
        result = 31 * result + (shipState != null ? shipState.hashCode() : 0);
        result = 31 * result + (shipCountry != null ? shipCountry.hashCode() : 0);
        result = 31 * result + (shippingFee != null ? shippingFee.hashCode() : 0);
        result = 31 * result + (paymentTypeId != null ? paymentTypeId.hashCode() : 0);
        result = 31 * result + (paidDate != null ? paidDate.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
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

    public RoleUserEntity getRoleUserByEmployeeId() {
        return roleUserByEmployeeId;
    }

    public void setRoleUserByEmployeeId(RoleUserEntity roleUserByEmployeeId) {
        this.roleUserByEmployeeId = roleUserByEmployeeId;
    }

    public ShopCustomerEntity getShopCustomerByCustomerId() {
        return shopCustomerByCustomerId;
    }

    public void setShopCustomerByCustomerId(ShopCustomerEntity shopCustomerByCustomerId) {
        this.shopCustomerByCustomerId = shopCustomerByCustomerId;
    }

    public ShopPaymentTypesEntity getShopPaymentTypesByPaymentTypeId() {
        return shopPaymentTypesByPaymentTypeId;
    }

    public void setShopPaymentTypesByPaymentTypeId(ShopPaymentTypesEntity shopPaymentTypesByPaymentTypeId) {
        this.shopPaymentTypesByPaymentTypeId = shopPaymentTypesByPaymentTypeId;
    }
}
