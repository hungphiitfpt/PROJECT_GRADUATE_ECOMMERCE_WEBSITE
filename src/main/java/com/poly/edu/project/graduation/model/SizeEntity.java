package com.poly.edu.project.graduation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "size", schema = "PROJECT_GRADUATE_ECOMMERCE_WEBSITE", catalog = "")
public class SizeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsize", nullable = false)
    private String idsize;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @OneToMany(mappedBy = "sizeBySize")
    @JsonBackReference
    private List<ProductsEntity> productsByIdsize;

    public String getIdsize() {
        return idsize;
    }

    public void setIdsize(String idsize) {
        this.idsize = idsize;
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

        SizeEntity that = (SizeEntity) o;

        if (idsize != that.idsize) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }


    public List<ProductsEntity> getProductsByIdsize() {
        return productsByIdsize;
    }

    public void setProductsByIdsize(List<ProductsEntity> productsByIdsize) {
        this.productsByIdsize = productsByIdsize;
    }
}
