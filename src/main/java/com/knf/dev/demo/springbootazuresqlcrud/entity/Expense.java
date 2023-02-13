package com.knf.dev.demo.springbootazuresqlcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Expense")
public class Expense {

    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "income")
    private Float income;

    @Column(name = "expense")
    private Float expense;

    @Column(name = "balance")
    private Float balance;




    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getIncome() {
        return this.income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public Float getExpense() {
        return this.expense;
    }

    public void setExpense(Float expense) {
        this.expense = expense;
    }

    public Float getBalance() {
        return this.balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Expense() {
		super();
	}

    
	
    public Expense(String user_id, String category, String description,Float income, Float expense,Float balance) {
		super();
		this.user_id = user_id;
		this.category = category;
		this.description = description;
		this.income=income;
		this.expense = expense;
		this.balance=balance;
	}
    
 

	 




}
