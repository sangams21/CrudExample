package com.sangam.crudPractice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangam.crudPractice.Entity.Product;


//<we have specify entity name and primery key of table>

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

	
	

}
