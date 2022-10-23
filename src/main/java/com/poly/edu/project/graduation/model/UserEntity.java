package com.poly.edu.project.graduation.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user", schema = "ecommer_db", catalog = "")
public class UserEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private long id;
	@Basic
	@Column(name = "username", nullable = true, length = 405)
	private String username;
	@Basic
	@Column(name = "password", nullable = true, length = 500)
	private String password;
	@Basic
	@Column(name = "last_name", nullable = true, length = 45)
	private String lastName;
	@Basic
	@Column(name = "first_name", nullable = true, length = 45)
	private String firstName;
	@Basic
	@Column(name = "gender", nullable = true)
	private Boolean gender;
	@Basic
	@Column(name = "email", nullable = true, length = 200)
	private String email;
	@Basic
	@Column(name = "birthday", nullable = true)
	private Timestamp birthday;
	@Basic
	@Column(name = "avatar", nullable = true, length = 200)
	private String avatar;
	@Basic
	@Column(name = "address", nullable = true, length = 400)
	private String address;
	@Basic
	@Column(name = "country", nullable = true, length = 45)
	private String country;
	@Basic
	@Column(name = "city", nullable = true, length = 45)
	private String city;
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

	  
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private List<RoleUserEntity> roles = new ArrayList<>();
	
	@OneToMany(mappedBy = "UserReviewProduct")
	private List<ShopProductReviewsEntity> entities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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



	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<RoleUserEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleUserEntity> roles) {
		this.roles = roles;
	}
	

}
