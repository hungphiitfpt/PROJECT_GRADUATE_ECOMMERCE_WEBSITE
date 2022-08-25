package com.poly.edu.project.graduation.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Products", schema = "ECOMMERCE_WEBSITE", catalog = "")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public int id; 
	@Basic
	@Column(name = "name")
	public String name;
	
	@Basic
	@Column(name = "amount")
	public String amount;
	
	@Basic 
	@Column(name = "idcolor")
	public String idColor;
	
	@Basic
	@Column(name = "typegoods")
	public String typeGoods;
	
	@Basic
	@Column(name = "image")
	public String image;
	
	@ManyToOne
	@JoinColumn(name = "category" , referencedColumnName = "id")
	private Categories categories;
}
