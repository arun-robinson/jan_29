package com.knf.dev.demo.springbootazuresqlcrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.event.spi.PreDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.demo.springbootazuresqlcrud.entity.Products;
import com.knf.dev.demo.springbootazuresqlcrud.exception.UserNotFound;
import com.knf.dev.demo.springbootazuresqlcrud.repository.ProductsRepository;



@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    @Autowired
	ProductsRepository productsRepository;

    
    // Create expense
	@PostMapping
	public ResponseEntity<Products> createProduct(@RequestBody Products product) {

		Products newproduct = new Products(
		product.getProduct_code(),
        product.getDescription(), 
        product.getRem_days(),
        product.getRem_months(),
        product.getCreated(), 
        product.getUpdated(),
		product.getProduction_date(),
		product.getProduct_group(),
		product.getProduct_name(),
		product.getProduct_serial(),
		product.getNo_of_cartons_received(),
		product.getProduct_key()


		/*String product_code,  
		String description,
		int rem_days,
		int rem_months,
		Date created,
		Date updated,
		Date production_date,
		String product_group,
		String product_name,
		String product_serial,
		int no_of_cartons_received,
		String product_key*/
        
        );
		productsRepository.save(newproduct);
		return new ResponseEntity<>(newproduct, HttpStatus.CREATED);

	}

     // Update Expense
	@PutMapping("/{id}")
	public ResponseEntity<Products> updateUser(@PathVariable("id") Long id, @RequestBody Products prd) {

		Optional<Products> prddata = productsRepository.findById(id);

		if (prddata.isPresent()) {
			Products product = prddata.get();
			product.setProduct_code(prd.getProduct_code()); 
			product.setDescription(prd.getDescription());;
			product.setRem_days(prd.getRem_days());
			product.setRem_months(prd.getRem_months());
			product.setUpdated(prd.getUpdated());
			product.setCreated(prd.getCreated());
          


			return new ResponseEntity<>(productsRepository.save(product), HttpStatus.OK);
		} else {
			throw new UserNotFound("Invalid expense Id");
		}
	}


    // Get all Products
	@GetMapping
	public ResponseEntity<List<Products>> getAllExpenses() {

		List<Products> products = new ArrayList<Products>();
		productsRepository.findAll().forEach(products::add);
		return new ResponseEntity<>(products, HttpStatus.OK);

	}


    // Get product by ID
	@GetMapping("/{id}")
	public ResponseEntity<Products> getUserByID(@PathVariable("id") Long id) {

		Optional<Products> prddata = productsRepository.findById(id);
		if (prddata.isPresent()) {
			return new ResponseEntity<>(prddata.get(), HttpStatus.OK);
		} else {
			throw new UserNotFound("Invalid product Id");
		}

	}

    // Delete product
	@DeleteMapping("/{id}")
	public ResponseEntity<Products> deleteUser(@PathVariable("id") Long id) {

		Optional<Products> expdata = productsRepository.findById(id);
		if (expdata.isPresent()) {
			productsRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			throw new UserNotFound("Invalid expense Id");
		}
	}


}
