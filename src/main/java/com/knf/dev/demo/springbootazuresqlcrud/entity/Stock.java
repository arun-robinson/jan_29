package com.knf.dev.demo.springbootazuresqlcrud.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "istock")
public class Stock {

        
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_id;

    @Column(name = "product_key")
    private String product_key;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "category_id")
    private int category_id;

    @Column(name="production_date")
    private Date production_date;

    @Column(name="number_of_cartons_received")
    private int number_of_cartons_received;

    @Column(name="expiry_date")
    private Date expiry_date;

    @Column(name="receiving_date")
    private Date receiving_date;

    public int getTransaction_id() {
        return this.transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getProduct_key() {
        return this.product_key;
    }

    public void setProduct_key(String product_key) {
        this.product_key = product_key;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Date getProduction_date() {
        return this.production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public int getNumber_of_cartons_received() {
        return this.number_of_cartons_received;
    }

    public void setNumber_of_cartons_received(int number_of_cartons_received) {
        this.number_of_cartons_received = number_of_cartons_received;
    }

    public Date getExpiry_date() {
        return this.expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public Date getReceiving_date() {
        return this.receiving_date;
    }

    public void setReceiving_date(Date receiving_date) {
        this.receiving_date = receiving_date;
    }


    

    public Stock() {
		super();
	}

    
	
    public Stock(

    int transaction_id,  
    String product_key,
    int product_id,
    int category_id,
    Date production_date,
    int number_of_cartons_received,
    Date expiry_date,
    Date receiving_date
  

     ) {
		super();
		this.transaction_id = transaction_id;
		this.product_key = product_key;
		this.product_id = product_id;
		this.category_id=category_id;
		this.production_date = production_date;
		this.production_date=production_date;
        this.number_of_cartons_received=number_of_cartons_received;
        this.expiry_date=expiry_date;
        this.receiving_date = receiving_date;
         

	}




}
