package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Timestamp;

@Entity
@Table(name = "shop_comments_blog", schema = "ecommer_db", catalog = "")
public class ShopCommentsBlogEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "blog_id", nullable = true)
    private Integer blogId;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Long userId;
    @Basic
    @Column(name = "comment", nullable = true, length = 500)
    private String comment;
    @Basic
    @Column(name = "create_date", nullable = true)
    private Timestamp createDate;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "is_deleted", nullable = true)
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShopBlogsEntity shopBlogsByBlogId;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private AppUserEntity appUserByUserId;
    
    

    public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopCommentsBlogEntity that = (ShopCommentsBlogEntity) o;

        if (id != that.id) return false;
        if (blogId != null ? !blogId.equals(that.blogId) : that.blogId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (blogId != null ? blogId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    public ShopBlogsEntity getShopBlogsByBlogId() {
        return shopBlogsByBlogId;
    }

    public void setShopBlogsByBlogId(ShopBlogsEntity shopBlogsByBlogId) {
        this.shopBlogsByBlogId = shopBlogsByBlogId;
    }
}
