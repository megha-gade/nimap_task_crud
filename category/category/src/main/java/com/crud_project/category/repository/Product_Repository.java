package com.crud_project.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_project.category.dto.Product;

public interface Product_Repository extends JpaRepository<Product, Integer> {

	
	  
}
