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

import com.knf.dev.demo.springbootazuresqlcrud.entity.Expense;
import com.knf.dev.demo.springbootazuresqlcrud.exception.UserNotFound;
import com.knf.dev.demo.springbootazuresqlcrud.repository.ExpenseRepository;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController{

    @Autowired
	ExpenseRepository expenseRepository;

    // Create expense
	@PostMapping
	public ResponseEntity<Expense> createUser(@RequestBody Expense expense) {

		Expense newexpense = new Expense(expense.getUser_id(), expense.getCategory(), expense.getDescription(), expense.getIncome(),
        expense.getExpense(), expense.getBalance());
		expenseRepository.save(newexpense);
		return new ResponseEntity<>(newexpense, HttpStatus.CREATED);

	}



    // Update Expense
	@PutMapping("/{id}")
	public ResponseEntity<Expense> updateUser(@PathVariable("id") Long id, @RequestBody Expense user) {

		Optional<Expense> expdata = expenseRepository.findById(id);

		if (expdata.isPresent()) {
			Expense expense = expdata.get();
			expense.setUser_id(user.getUser_id()); 
			expense.setCategory(user.getCategory());
			expense.setDescription(user.getDescription());
			expense.setIncome(user.getIncome());
			expense.setExpense(user.getExpense());
			expense.setBalance(user.getBalance());

			return new ResponseEntity<>(expenseRepository.save(expense), HttpStatus.OK);
		} else {
			throw new UserNotFound("Invalid expense Id");
		}
	}

	// Get all Expenses
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {

		List<Expense> expenses = new ArrayList<Expense>();
		expenseRepository.findAll().forEach(expenses::add);
		return new ResponseEntity<>(expenses, HttpStatus.OK);

	}

	// Get expense by ID
	@GetMapping("/{id}")
	public ResponseEntity<Expense> getUserByID(@PathVariable("id") Long id) {

		Optional<Expense> expdata = expenseRepository.findById(id);
		if (expdata.isPresent()) {
			return new ResponseEntity<>(expdata.get(), HttpStatus.OK);
		} else {
			throw new UserNotFound("Invalid expense Id");
		}

	}

	// Delete expense
	@DeleteMapping("/{id}")
	public ResponseEntity<Expense> deleteUser(@PathVariable("id") Long id) {

		Optional<Expense> expdata = expenseRepository.findById(id);
		if (expdata.isPresent()) {
			expenseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			throw new UserNotFound("Invalid expense Id");
		}
	}



}