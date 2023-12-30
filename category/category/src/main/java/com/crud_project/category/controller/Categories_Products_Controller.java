package com.crud_project.category.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud_project.category.dao.Categories_Product_Dao;
import com.crud_project.category.dto.Category;
import com.crud_project.category.dto.Product;
import com.crud_project.category.service.Category_Product_Service;



@RestController
public class Categories_Products_Controller {
	
	
	
	@Autowired
	private Category_Product_Service service;
	
	
	
	
//	Create Category
	@PostMapping("api/categories")
	public Category saveCategory(@RequestBody Category category)
	{
		System.out.println(category);
		return service.saveCategory(category);
	}
	
	

	
	
	//Get All Categories
	@GetMapping("api/categories")
	public List<Category> getAllCategory(
			@RequestParam(value = "pagenumber",defaultValue="0", required=false)Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = "4",required = false)Integer pagesize
			)
	{
		
		return service.getAllCategory(pagenumber,pagesize);
	}
	
	
	
	//Get Category By ID
	@GetMapping("api/categories/{di}")
	public Optional<Category> getById(@PathVariable("di")int id) {
		return service.getCategoryById(id);
	}
	
   //	path variable value and url value should same i,e
	
	
	
	
	//Update  Category By ID
	@PutMapping("api/categories/{di}")
	public Category updateCategory(@RequestBody Category category,
			@PathVariable("di") int id)
	{
		System.out.println(category);
		return service.updateCategory(category,id);
	}
	
	
	
	//Delete Category BY ID
	@DeleteMapping("api/categories/{di}")
	public void deleteById(@PathVariable("di") int id) {
		service.deleteCategory(id);
	}
	
	
	
	//Create Product
	@PostMapping("api/products")
	public Product saveProduct(@RequestBody Product product)
	{
		System.out.println(product);
		return service.saveProduct(product);
	}
	
	
	
	
	//Get All Product
	@GetMapping("api/products")
	public List<Product> getAllProduct(
			@RequestParam(value = "pagenumber",defaultValue="0", required=false)Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = "5",required = false)Integer pagesize
			)
	{
		return service.getAllProduct(pagenumber,pagesize);
	}
	
	
	
	//Get BY ID
	@GetMapping("api/products/{id}")
	public Optional<Product> getProductById(@PathVariable("id") int id)
	{
		return service.findById(id);
	}
	
	
	
	
	//Update product  BY ID
		@PutMapping("api/products/{di}")
		public Product updateProduct(@RequestBody Product products,
				@PathVariable("di") int id)
		{
			System.out.println(products);
			return service.updateproduct(products,id);
         }
		
		
		
		//Delete BY ID
		@DeleteMapping("api/products/{di}")
		public void deleteProductById(@PathVariable("di") int id)
		{
			service.deleteProductById(id);
		}
		

}
