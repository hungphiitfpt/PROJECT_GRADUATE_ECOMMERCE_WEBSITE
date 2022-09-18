package com.poly.edu.project.graduation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color", schema = "PROJECT_GRADUATE_ECOMMERCE_WEBSITE", catalog = "")
public class ColorEntity {

    @Id
    @Column(name = "idcolor", nullable = false)
    private String idcolor;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @OneToMany(mappedBy = "colorByColor")
    @JsonBackReference
    private List<ProductsEntity> productsByIdcolor;

    public String getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(String idcolor) {
        this.idcolor = idcolor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductsEntity> getProductsByIdcolor() {
        return productsByIdcolor;
    }

    public void setProductsByIdcolor(List<ProductsEntity> productsByIdcolor) {
        this.productsByIdcolor = productsByIdcolor;
    }
}
