package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

@Entity
@Table(name = "shop_product_vouchers", schema = "ecommer_db", catalog = "")
public class ShopProductVouchersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "product_id", nullable = true)
    private Long productId;
    @Basic
    @Column(name = "voucher_id", nullable = true)
    private Long voucherId;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "isdeleted_at", nullable = true)
    private Boolean isdeletedAt;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
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

    public Boolean getIsdeletedAt() {
        return isdeletedAt;
    }

    public void setIsdeletedAt(Boolean isdeletedAt) {
        this.isdeletedAt = isdeletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProductVouchersEntity that = (ShopProductVouchersEntity) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (voucherId != null ? !voucherId.equals(that.voucherId) : that.voucherId != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (isdeletedAt != null ? !isdeletedAt.equals(that.isdeletedAt) : that.isdeletedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (voucherId != null ? voucherId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (isdeletedAt != null ? isdeletedAt.hashCode() : 0);
        return result;
    }

    public ShopProductsEntity getShopProductsByProductId() {
        return shopProductsByProductId;
    }

    public void setShopProductsByProductId(ShopProductsEntity shopProductsByProductId) {
        this.shopProductsByProductId = shopProductsByProductId;
    }
}
