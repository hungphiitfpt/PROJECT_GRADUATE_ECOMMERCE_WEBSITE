package com.poly.edu.project.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "PROJECT_GRADUATE_ECOMMERCE_WEBSITE", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproduct", nullable = false)
    private int idproduct;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @Basic
    @Column(name = "size", nullable = true)
    private Integer size;
    @Basic
    @Column(name = "color", nullable = true)
    private Integer color;
    @Basic
    @Column(name = "category", nullable = true)
    private Integer category;
    @Basic
    @Column(name = "image", nullable = true, length = 200)
    private String image;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
    @ManyToOne
    @JoinColumn(name = "size", referencedColumnName = "idsize",insertable = false,updatable = false)
    private SizeEntity sizeBySize;
    @ManyToOne
    @JoinColumn(name = "color", referencedColumnName = "idcolor",insertable = false,updatable = false)
    private ColorEntity colorByColor;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "idcategory",insertable = false,updatable = false)
    private CategoryEntity categoryByCategory;

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (idproduct != that.idproduct) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproduct;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public SizeEntity getSizeBySize() {
        return sizeBySize;
    }

    public void setSizeBySize(SizeEntity sizeBySize) {
        this.sizeBySize = sizeBySize;
    }

    public ColorEntity getColorByColor() {
        return colorByColor;
    }

    public void setColorByColor(ColorEntity colorByColor) {
        this.colorByColor = colorByColor;
    }

    public CategoryEntity getCategoryByCategory() {
        return categoryByCategory;
    }

    public void setCategoryByCategory(CategoryEntity categoryByCategory) {
        this.categoryByCategory = categoryByCategory;
    }
}
