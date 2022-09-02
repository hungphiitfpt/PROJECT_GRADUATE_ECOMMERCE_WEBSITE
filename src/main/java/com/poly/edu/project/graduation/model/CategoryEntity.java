package com.poly.edu.project.graduation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category", schema = "PROJECT_GRADUATE_ECOMMERCE_WEBSITE", catalog = "")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategory", nullable = false)
    private int idcategory;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @OneToMany(mappedBy = "categoryByCategory")
    @JsonBackReference
    private List<ProductsEntity> productsByIdcategory;

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (idcategory != that.idcategory) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public List<ProductsEntity> getProductsByIdcategory() {
        return productsByIdcategory;
    }

    public void setProductsByIdcategory(List<ProductsEntity> productsByIdcategory) {
        this.productsByIdcategory = productsByIdcategory;
    }
}
