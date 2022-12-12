package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "shop_blogs", schema = "ecommer_db", catalog = "")
public class ShopBlogsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "blog_title", nullable = true, length = 200)
    private String blogTitle;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Long userId;
    @Basic
    @Column(name = "first_paragraph", nullable = true, length = 500)
    private String firstParagraph;
    @Basic
    @Column(name = "body_ paragraph", nullable = true, length = 500)
    private String bodyParagraph;
    @Basic
    @Column(name = "ending_paragraph", nullable = true, length = 500)
    private String endingParagraph;
    @Basic
    @Column(name = "category_id", nullable = true)
    private Integer categoryId;
    @Basic
    @Column(name = "create_date", nullable = true)
    private Timestamp createDate;
    @Basic
    @Column(name = "update_date", nullable = true)
    private Timestamp updateDate;
    @Basic
    @Column(name = "image", nullable = true, length = 500)
    private String image;
    @Basic
    @Column(name = "is_deleted", nullable = true, length = 500)
    private boolean is_deleted;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategoryBlogEntity categoryBlogByCategoryId;

    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private AppUserEntity appUserByUserId;
    
 
    public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public AppUserEntity getAppUserByUserId() {
		return appUserByUserId;
	}

	public void setAppUserByUserId(AppUserEntity appUserByUserId) {
		this.appUserByUserId = appUserByUserId;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstParagraph() {
        return firstParagraph;
    }

    public void setFirstParagraph(String firstParagraph) {
        this.firstParagraph = firstParagraph;
    }

    public String getBodyParagraph() {
        return bodyParagraph;
    }

    public void setBodyParagraph(String bodyParagraph) {
        this.bodyParagraph = bodyParagraph;
    }

    public String getEndingParagraph() {
        return endingParagraph;
    }

    public void setEndingParagraph(String endingParagraph) {
        this.endingParagraph = endingParagraph;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopBlogsEntity that = (ShopBlogsEntity) o;

        if (id != that.id) return false;
        if (blogTitle != null ? !blogTitle.equals(that.blogTitle) : that.blogTitle != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (firstParagraph != null ? !firstParagraph.equals(that.firstParagraph) : that.firstParagraph != null)
            return false;
        if (bodyParagraph != null ? !bodyParagraph.equals(that.bodyParagraph) : that.bodyParagraph != null)
            return false;
        if (endingParagraph != null ? !endingParagraph.equals(that.endingParagraph) : that.endingParagraph != null)
            return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (blogTitle != null ? blogTitle.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (firstParagraph != null ? firstParagraph.hashCode() : 0);
        result = 31 * result + (bodyParagraph != null ? bodyParagraph.hashCode() : 0);
        result = 31 * result + (endingParagraph != null ? endingParagraph.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }

    public CategoryBlogEntity getCategoryBlogByCategoryId() {
        return categoryBlogByCategoryId;
    }

    public void setCategoryBlogByCategoryId(CategoryBlogEntity categoryBlogByCategoryId) {
        this.categoryBlogByCategoryId = categoryBlogByCategoryId;
    }


}
