package com.crud_project.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud_project.category.dao.Categories_Product_Dao;
import com.crud_project.category.dto.Category;
import com.crud_project.category.dto.Product;
import com.crud_project.category.repository.Category_Repository;
import com.crud_project.category.repository.Product_Repository;

@Service
public class Category_Product_Service {
	
	@Autowired
	Categories_Product_Dao dao;
    //	object of dao class
	
	
	
	
	
     //	create category
	 public Category saveCategory(Category category) {
			return dao.saveCategory(category);
		}
	 
	 
          //find by id	 
		public Optional<Category> getCategoryById(int id)
		{
			return dao.getCategoryById(id);
		}
		
		
		
		public List<Category> getAllCategory(int pagenumber,int pagesize)
		{
			
			return dao.getAllCategory(pagenumber,pagesize);
		}
		
		
		
//		update category
		
		public Category updateCategory(Category category, int id) {
			Optional<Category> catOptional=dao.getCategoryById(id);
			
			
			
			category.setId(id);
			return dao.saveCategory(category);
		}
		
		

		//delete
		public void deleteCategory(int id) {
			dao.deleteCategory(id);
		}
		
		

		//>>>>>>>>>>Product related CRUD Operations <<<<<<<<<<<<<<<<<<<<<<<
		
		//save or create product
		public Product saveProduct(Product product) {
			return dao.saveProduct(product);
		}
		
		//get all products
		public List<Product> getAllProduct(int pagenumber,int pagesize) {
			return dao.getAllProduct(pagenumber, pagesize);
		}
		
		
		
		//find product by id
		public Optional<Product> findById(int id) {
			return dao.findById(id);
		}
		
		
		//update product
		public Product updateproduct(Product product, int id) {
			Optional<Product> proOptional=dao.findById(id);
			product.setId(id);
	     //	set the updated value	
			return dao.saveProduct(product);
		}
		
		
		//delete product by id
//		public void deleteProductById(int id) {
//			dao.deleteProductById(id);
//		}
		
		
		
		
		public void deleteProductById(int id) {
		   dao.deleteProductById(id);
		}

}
