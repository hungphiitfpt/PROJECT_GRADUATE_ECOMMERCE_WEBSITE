package com.poly.edu.project.graduation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color", schema = "PROJECT_GRADUATE_ECOMMERCE_WEBSITE", catalog = "")
public class ColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcolor", nullable = false)
    private int idcolor;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @OneToMany(mappedBy = "colorByColor")
    @JsonBackReference
    private List<ProductsEntity> productsByIdcolor;

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
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

        ColorEntity that = (ColorEntity) o;

        if (idcolor != that.idcolor) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcolor;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public List<ProductsEntity> getProductsByIdcolor() {
        return productsByIdcolor;
    }

    public void setProductsByIdcolor(List<ProductsEntity> productsByIdcolor) {
        this.productsByIdcolor = productsByIdcolor;
    }
}
