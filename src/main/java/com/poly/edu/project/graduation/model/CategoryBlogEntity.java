package com.poly.edu.project.graduation.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_blog", schema = "ecommer_db", catalog = "")
public class CategoryBlogEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 200)
    private String name;
    @OneToMany(mappedBy = "categoryBlogByCategoryId")
    private List<ShopBlogsEntity> shopBlogsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        CategoryBlogEntity that = (CategoryBlogEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public List<ShopBlogsEntity> getShopBlogsById() {
        return shopBlogsById;
    }

    public void setShopBlogsById(List<ShopBlogsEntity> shopBlogsById) {
        this.shopBlogsById = shopBlogsById;
    }
}
