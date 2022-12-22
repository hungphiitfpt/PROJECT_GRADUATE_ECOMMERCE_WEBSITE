package com.poly.edu.project.graduation.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "app_user", //
uniqueConstraints = { //
        @UniqueConstraint(name = "APP_USER_UK", columnNames = "user_name") })
public class AppUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic
    @Column(name = "user_name", nullable = false, length = 36)
    private String userName;
    @Basic
    @Column(name = "encryted_password", nullable = false, length = 128)
    private String encrytedPassword;
    @Basic
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
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
    private Date birthday;
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
    @OneToMany(mappedBy = "appUserByUserId")
    private List<UserRoleEntity> userRolesByUserId;
    @OneToMany(mappedBy = "appUserByUserId")
    private List<ShopOrdersEntity> shopOrdersByUserId;
    
    @Column(name = "reset_password_token")
    private String resetPasswordToken;
     

    public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUserEntity that = (AppUserEntity) o;

        if (userId != that.userId) return false;
        if (isDeleted != that.isDeleted) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (encrytedPassword != null ? !encrytedPassword.equals(that.encrytedPassword) : that.encrytedPassword != null)
            return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (encrytedPassword != null ? encrytedPassword.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public List<UserRoleEntity> getUserRolesByUserId() {
        return userRolesByUserId;
    }

    public void setUserRolesByUserId(List<UserRoleEntity> userRolesByUserId) {
        this.userRolesByUserId = userRolesByUserId;
    }

    public List<ShopOrdersEntity> getShopOrdersByUserId() {
        return shopOrdersByUserId;
    }

    public void setShopOrdersByUserId(List<ShopOrdersEntity> shopOrdersByUserId) {
        this.shopOrdersByUserId = shopOrdersByUserId;
    }
}
