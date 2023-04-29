package com.knf.dev.demo.springbootazuresqlcrud.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
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

import com.knf.dev.demo.springbootazuresqlcrud.entity.Stock;
import com.knf.dev.demo.springbootazuresqlcrud.exception.UserNotFound;
import com.knf.dev.demo.springbootazuresqlcrud.repository.StockRepository;
import com.knf.dev.demo.springbootazuresqlcrud.repository.UserRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
	StockRepository stockRepository;


    // Create user
	@PostMapping
	public ResponseEntity<Stock> createUser(@RequestBody Stock stock) {


		LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
    String timestampString = "IEFT" + now.format(formatter);
    System.out.println(timestampString);



        Stock stock1 = new Stock(
					stock.getTransaction_id(),
					timestampString,
					stock.getProduct_id(),
					stock.getCategory_id(),
					stock.getProduction_date(),
					stock.getNumber_of_cartons_received(),
					stock.getExpiry_date(),
					stock.getReceiving_date());

		

                stockRepository.save(stock1);
		return new ResponseEntity<>(stock1, HttpStatus.CREATED);

	}


	 // Get all Products
	 @GetMapping
	 public ResponseEntity<List<Stock>> getAllStocks() {
 
		 List<Stock> stocks = new ArrayList<Stock>();
		 stockRepository.findAll().forEach(stocks::add);
		 return new ResponseEntity<>(stocks, HttpStatus.OK);
 
	 }

	 
    // Get product by ID
	@GetMapping("/{id}")
	public ResponseEntity<Stock> getUserByID(@PathVariable("id") Long id) {

		Optional<Stock> stkdata = stockRepository.findById(id);
		if (stkdata.isPresent()) {
			return new ResponseEntity<>(stkdata.get(), HttpStatus.OK);
		} else {
			throw new UserNotFound("Invalid stoc Id");
		}

	}

    
}
