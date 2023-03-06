package com.knf.dev.demo.springbootazuresqlcrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.knf.dev.demo.springbootazuresqlcrud.entity.Category;
import com.knf.dev.demo.springbootazuresqlcrud.exception.UserNotFound;
import com.knf.dev.demo.springbootazuresqlcrud.repository.CategoryRepository;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
	CategoryRepository categoryRepository;

    
    // Create category
	@PostMapping
	public ResponseEntity<Category> createProduct(@RequestBody Category category) {

		Category newcategory = new Category( 
        category.getCategory_code(), 
        category.getCreated(),
        category.getUpdated()
        );
		categoryRepository.save(newcategory);
		return new ResponseEntity<>(newcategory, HttpStatus.CREATED);

	}

     // Update Expense
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateUser(@PathVariable("id") Long id, @RequestBody Category cat) {

		Optional<Category> catdata = categoryRepository.findById(id);

		if (catdata.isPresent()) {
			Category category = catdata.get();
			category.setCategory_code (cat.getCategory_code()); 
			category.setCreated (cat.getCreated());
			category.setUpdated(cat.getUpdated()); 
			 


			return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
		} else {
			throw new UserNotFound("Invalid category Id");
		}
	}


    // Get all Products
	@GetMapping
	public ResponseEntity<List<Category>> getAllExpenses() {

		List<Category> category = new ArrayList<Category>();
		categoryRepository.findAll().forEach(category::add);
		return new ResponseEntity<>(category, HttpStatus.OK);

	}


    // Get product by ID
	@GetMapping("/{id}")
	public ResponseEntity<Category> getUserByID(@PathVariable("id") Long id) {

		Optional<Category> catdata = categoryRepository.findById(id);
		if (catdata.isPresent()) {
			return new ResponseEntity<>(catdata.get(), HttpStatus.OK);
		} else {
			throw new UserNotFound("Invalid category Id");
		}

	}

    // Delete product
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteUser(@PathVariable("id") Long id) {

		Optional<Category> catdata = categoryRepository.findById(id);
		if (catdata.isPresent()) {
			categoryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			throw new UserNotFound("Invalid category Id");
		}
	}
}
