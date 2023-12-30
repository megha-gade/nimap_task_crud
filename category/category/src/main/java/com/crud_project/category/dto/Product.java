package com.crud_project.category.dto;

//@JsonIgnoreProoperties(to ignore multiple fields)

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Product {
	
	
	@Id
	@GeneratedValue
	(strategy = GenerationType.AUTO)
	private int id;
	private String product_name;
	private double product_price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Category category;
	
	@JsonIgnore
	public Category getCategory() {
		return category;
	}
	@JsonProperty
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_price=" + product_price
				+ ", category=" + category + "]";
	}
	
	
	
	
}
