package com.crud_project.category.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_id")
	private int id;
	@Column(name="c_category")
	private String category;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcategory() {
		return category;
	}
	
	
	public void setcategory(String category) {
		this.category = category;
	}
	
	
	public List<Product> getProduct() {
		return product;
	}
	
	
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
	@Override
	public String toString() {
		return "Category:: >>>>>[id= " + id + ", category= " + category + ", product= " + product + "]";
	}

}
