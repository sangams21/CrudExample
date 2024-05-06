package com.sangam.crudPractice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangam.crudPractice.Entity.Product;
import com.sangam.crudPractice.Repository.ProductRepository;


// Service layer talk to repository layer class 
@Service

public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	// post method for create or save a product 
	public Product saveProduct(Product product) {
	    return	repository.save(product);
		
	}
	
	// post method for create or save a list of product 
	public List<Product> saveProducts(List<Product> products) {
	    return	repository.saveAll(products);
		
	}
	
	// get method to retrive the list of product 
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	//get method to get the product  based on id 
	public Product getProductId(int id){
		return repository.findById(id).orElse(null);
	}
	
    // get method to get the data based on name 
	public Product getProductsName(String name){
		return repository.findByName(name);
	}
	
	// delete method to delete the data based on  id
	public String deleteProduct(int id) {
	   repository.deleteById(id);
	   return "product remove" +id;
		
	}
	
	// method for update the data based on my product id
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuentity(product.getQuentity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
		
	}
	

}
