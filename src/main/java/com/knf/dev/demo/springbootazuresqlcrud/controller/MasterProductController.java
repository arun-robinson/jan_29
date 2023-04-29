package com.knf.dev.demo.springbootazuresqlcrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

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
import com.knf.dev.demo.springbootazuresqlcrud.entity.Stock;
import com.knf.dev.demo.springbootazuresqlcrud.exception.UserNotFound;
import com.knf.dev.demo.springbootazuresqlcrud.repository.MasterProductsRepository;
import com.knf.dev.demo.springbootazuresqlcrud.repository.ProductsRepository;

import com.knf.dev.demo.springbootazuresqlcrud.entity.MasterProducts;

@RestController
@RequestMapping("/api/v1/masterproducts")
public class MasterProductController {

	@Autowired
	MasterProductsRepository masterProductsRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	// Get all Products
	@GetMapping
	public ResponseEntity<List<MasterProducts>> getAllMasterProducts() {

		List<MasterProducts> products = new ArrayList<MasterProducts>();
		masterProductsRepository.findAll().forEach(products::add);
		return new ResponseEntity<>(products, HttpStatus.OK);

	}

	// Create expense
	@PostMapping
	public String createProduct(@RequestBody Stock stock) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			Stock stock1 = new Stock(
					stock.getTransaction_id(),
					stock.getProduct_key(),
					stock.getProduct_id(),
					stock.getCategory_id(),
					stock.getProduction_date(),
					stock.getNumber_of_cartons_received(),
					stock.getExpiry_date(),
					stock.getReceiving_date());

			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("stockin");

			query.setParameter("transaction_id", stock1.getTransaction_id());
			query.setParameter("product_key", stock1.getProduct_key());
			query.setParameter("product_id", stock1.getProduct_id());
			query.setParameter("category_id", stock1.getCategory_id());

			query.setParameter("production_date", stock1.getProduction_date());
			query.setParameter("number_of_cartons_received", stock1.getNumber_of_cartons_received());
			query.setParameter("expiry_date", stock1.getExpiry_date());
			query.setParameter("receiving_date", stock1.getReceiving_date());

			// Set other parameters as needed
			String procedureCall = (String) query.getSingleResult();
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXProcedure call: " + procedureCall);
		} finally {
			entityManager.close();
		}

		return "";

	}

}
