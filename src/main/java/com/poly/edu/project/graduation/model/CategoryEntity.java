package com.poly.edu.project.graduation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category", schema = "PROJECT_GRADUATE_ECOMMERCE_WEBSITE", catalog = "")
public class CategoryEntity {
   
    @Id
    @Column(name = "idcategory", nullable = false)
    private String idcategory;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @OneToMany(mappedBy = "categoryByCategory")
    @JsonBackReference
    
    private List<ProductsEntity> productsByIdcategory;

    public String getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(String idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CategoryEntity(String idcategory, String name, List<ProductsEntity> productsByIdcategory) {
		super();
		this.idcategory = idcategory;
		this.name = name;
		this.productsByIdcategory = productsByIdcategory;
	}

    
	public CategoryEntity() {
		super();
	}

	public List<ProductsEntity> getProductsByIdcategory() {
        return productsByIdcategory;
    }

    public void setProductsByIdcategory(List<ProductsEntity> productsByIdcategory) {
        this.productsByIdcategory = productsByIdcategory;
    }
}
