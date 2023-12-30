package com.crud_project.category.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Repository;


import com.crud_project.category.dto.Category;
import com.crud_project.category.dto.Product;
import com.crud_project.category.repository.Category_Repository;
import com.crud_project.category.repository.Product_Repository;


@Repository
public class Categories_Product_Dao {

	
	@Autowired
	private Category_Repository category_Repository;
//	{to get the object of category_Repository}
	
	@Autowired
	private Product_Repository product_Repository;
//	{to get the object of product_Repository}
	
	//save or create

    public Category saveCategory(Category category)
    {
    List<Product>list=	category.getProduct();
    
    
    for(Product product:list)
    {
    	product.setCategory(category);
    }
    
    
		return category_Repository.save(category);
	}
 
	
	
	
	
	
	//find by id
   //with the help of optional class
    
	public Optional<Category> getCategoryById(int id)
	{
		return category_Repository.findById(id);
	}
	
	
	
	
	
	//find all
	public List<Category> getAllCategory(int pagenumber,int pagesize) {
		Pageable p = PageRequest.of(pagenumber, pagesize);
		Page<Category> page =category_Repository.findAll(p);
		return page.getContent();
	}
	
	
	
	
	 // update
     //	first find by the id then set that id in
     //	category object using setId()
     //	then save it again
	
	public Category updateCategory(Category category, int id)
	{
		Optional<Category> catOptional=category_Repository.findById(id);
		
		
		category.setId(id);
		return category_Repository.save(category);
	}
	
	
	
	
	//delete
	public void deleteCategory(int id) {
		category_Repository.deleteById(id);
	}
	
	
	
	
	
	//>>>>>>>>>>Product related CRUD Operations <<<<<<<<<<<<<<<<<<<<<<<
	
	//save or create product
	public Product saveProduct(Product product) {
		return product_Repository.save(product);
	}
	
	
	
	
	//get all products
	public List<Product> getAllProduct(int pagenumber,int pagesize) {
		Pageable p = PageRequest.of(pagenumber, pagesize);
		Page<Product> page1 =product_Repository.findAll(p);
		return page1.getContent();
	}
	
	
	
	
	
	//find product by id
	public Optional<Product> findById(int id) {
		return product_Repository.findById(id);
	}
	
	
	
	
	

	//update product
	public Product updateproduct(Product product, int id) {
		Optional<Product> proOptional=product_Repository.findById(id);
		product.setId(id);
     //	set the updated value	
		return product_Repository.save(product);
	}
	
	
	
	
//	delete product by id
	

	public void deleteProductById(int id) {
	    Optional<Product> productOptional = product_Repository.findById(id);

	    if (productOptional.isPresent()) {
	        Product productToDelete = productOptional.get();
	        Category productCategory = productToDelete.getCategory();

	        if (productCategory != null) {
	            productCategory.getProduct().remove(productToDelete);
	        }
	        
	        else
	        {
	        	System.out.println("that product has no category"
	        			           + " ,it is single product ");
	        	
	        	product_Repository.delete(productToDelete);
	        }

	        product_Repository.delete(productToDelete);
	    }
	    
	    
	    
	}
	
	
	
	
	
	









	






	
}
