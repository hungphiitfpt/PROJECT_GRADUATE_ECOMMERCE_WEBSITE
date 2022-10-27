package com.poly.edu.project.graduation.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "roles", schema = "ecommer_db", catalog = "")
public class RoleUserEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private long id;
	
	@Basic
	@Column(name = "name", nullable = true, length = 45)
	private String name;
	
	@Basic
	@CreationTimestamp
	@Column(name = "created_at", nullable = true)
	private Timestamp createdAt;
	
	@Basic
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = true)
	private Timestamp updatedAt;
	
	@Basic
	@Column(name = "is_deleted", nullable = true)
	private Boolean isDeleted;
	
	
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
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


}
