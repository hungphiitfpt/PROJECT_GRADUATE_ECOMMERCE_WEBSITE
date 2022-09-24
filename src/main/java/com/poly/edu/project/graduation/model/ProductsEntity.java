package com.poly.edu.project.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "PROJECT_GRADUATE_ECOMMERCE_WEBSITE", catalog = "")
public class ProductsEntity {

	@Id
	@Column(name = "idproduct", nullable = false)
	private int idproduct;
	@Basic
	@Column(name = "name", nullable = true, length = 100)
	private String name;
	@Basic
	@Column(name = "size", nullable = true)
	private String size;
	@Basic
	@Column(name = "color", nullable = true)
	private String color;
	@Basic
	@Column(name = "category", nullable = true)
	private String category;
	@Basic
	@Column(name = "image", nullable = true, length = 200)
	private String image;
	@Basic
	@Column(name = "price", nullable = true, precision = 0)
	private Double price;
	@Basic
	@Column(name = "saleoff", nullable = true, precision = 0)
	private Integer saleoff;
	@Basic
	@Column(name = "quantity", nullable = true, precision = 0)
	private Integer quantity;
	@Basic
	@Column(name = "description", nullable = true, precision = 0)
	private String description;
	@ManyToOne
	@JoinColumn(name = "size", referencedColumnName = "idsize", insertable = false, updatable = false)
	private SizeEntity sizeBySize;
	@ManyToOne
	@JoinColumn(name = "color", referencedColumnName = "idcolor", insertable = false, updatable = false)
	private ColorEntity colorByColor;
	@ManyToOne
	@JoinColumn(name = "category", referencedColumnName = "idcategory", insertable = false, updatable = false)
	private CategoryEntity categoryByCategory;

	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductsEntity(int idproduct, String name, String size, String color, String category, String image,
			Double price, Integer saleoff, Integer quantity, SizeEntity sizeBySize, ColorEntity colorByColor,
			CategoryEntity categoryByCategory) {
		super();
		this.idproduct = idproduct;
		this.name = name;
		this.size = size;
		this.color = color;
		this.category = category;
		this.image = image;
		this.price = price;
		this.saleoff = saleoff;
		this.quantity = quantity;
		this.sizeBySize = sizeBySize;
		this.colorByColor = colorByColor;
		this.categoryByCategory = categoryByCategory;
	}

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
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

	public Integer getSaleoff() {
		return saleoff;
	}

	public void setSaleoff(Integer saleoff) {
		this.saleoff = saleoff;
	}
	public ProductsEntity() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ProductsEntity that = (ProductsEntity) o;

		if (idproduct != that.idproduct)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (size != null ? !size.equals(that.size) : that.size != null)
			return false;
		if (color != null ? !color.equals(that.color) : that.color != null)
			return false;
		if (category != null ? !category.equals(that.category) : that.category != null)
			return false;
		if (image != null ? !image.equals(that.image) : that.image != null)
			return false;
		if (price != null ? !price.equals(that.price) : that.price != null)
			return false;

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
