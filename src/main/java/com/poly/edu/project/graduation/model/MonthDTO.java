package com.poly.edu.project.graduation.model;

import java.io.Serializable;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import lombok.Data;




//@NamedNativeQuery(name = "MonthDTO.GET12MONTH",
//query = "SELECT * FROM shop_orders",
//resultSetMapping = "Mapping.MonthDTO")
//@SqlResultSetMapping(name = "Mapping.MonthDTO",
//   classes = @ConstructorResult(targetClass = MonthDTO.class,
//                                columns = {@ColumnResult(name = "first"),
//                                           @ColumnResult(name = "last")}))

public class MonthDTO implements Serializable{

	
	private String January;
	private String February;
	private String March;
	private String April;
	private String May;
	private String June;
	private String July;
	private String August;
	private String September;
	private String October;
	private String November;
	private String December;
	

	public String getJanuary() {
		return January;
	}
	public void setJanuary(String january) {
		January = january;
	}
	public String getFebruary() {
		return February;
	}
	public void setFebruary(String february) {
		February = february;
	}
	public String getMarch() {
		return March;
	}
	public void setMarch(String march) {
		March = march;
	}
	public String getApril() {
		return April;
	}
	public void setApril(String april) {
		April = april;
	}
	public String getMay() {
		return May;
	}
	public void setMay(String may) {
		May = may;
	}
	public String getJune() {
		return June;
	}
	public void setJune(String june) {
		June = june;
	}
	public String getJuly() {
		return July;
	}
	public void setJuly(String july) {
		July = july;
	}
	public String getAugust() {
		return August;
	}
	public void setAugust(String august) {
		August = august;
	}
	public String getSeptember() {
		return September;
	}
	public void setSeptember(String september) {
		September = september;
	}
	public String getOctober() {
		return October;
	}
	public void setOctober(String october) {
		October = october;
	}
	public String getNovember() {
		return November;
	}
	public void setNovember(String november) {
		November = november;
	}
	public String getDecember() {
		return December;
	}
	public void setDecember(String december) {
		December = december;
	}
	public MonthDTO(String january, String february, String march, String april, String may, String june, String july,
			String august, String september, String october, String november, String december) {

		January = january;
		February = february;
		March = march;
		April = april;
		May = may;
		June = june;
		July = july;
		August = august;
		September = september;
		October = october;
		November = november;
		December = december;
	}
	public MonthDTO() {
	
	}
	
	

}
