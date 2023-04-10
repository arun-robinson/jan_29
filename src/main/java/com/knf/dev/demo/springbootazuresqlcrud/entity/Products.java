package com.knf.dev.demo.springbootazuresqlcrud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Products")
public class Products {


    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    @Column(name = "product_code")
    private String product_code;


    @Column(name = "description")
    private String description;

    @Column(name = "rem_days")
    private int rem_days;

    @Column(name = "rem_months")
    private int rem_months;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    @Column(name = "production_date")
    private Date production_date;

    @Column(name = "product_group")
    private String product_group;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_serial")
    private String product_serial;

    @Column(name = "no_of_cartons_received")
    private int no_of_cartons_received;

    @Column(name = "product_key")
    private String product_key;

    public Date getProduction_date() {
        return this.production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    

    public String getProduct_group() {
        return this.product_group;
    }

    public void setProduct_group(String product_group) {
        this.product_group = product_group;
    }

   
    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

     

    public String getProduct_serial() {
        return this.product_serial;
    }

    public void setProduct_serial(String product_serial) {
        this.product_serial = product_serial;
    }

    

    public int getNo_of_cartons_received() {
        return this.no_of_cartons_received;
    }

    public void setNo_of_cartons_received(int no_of_cartons_received) {
        this.no_of_cartons_received = no_of_cartons_received;
    }

    

    public String getProduct_key() {
        return this.product_key;
    }

    public void setProduct_key(String product_key) {
        this.product_key = product_key;
    }
    

    public Long getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_code() {
        return this.product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRem_days() {
		return this.rem_days;
	}

    public void setRem_days(int rem_days) {
		this.rem_days =rem_days ;
	}

    public int getRem_months() {
        return this.rem_months;
    }

    public void setRem_months(int rem_months) {
        this.rem_months = rem_months;
    }

    public Date getCreated() {
		return this.created;
	}

    public void setCreated(Date created) {
		this.created =  created ;
	}

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    

     
      

     

     


    public Products() {
		super();
	}

    
	
    public Products(

     String product_code,  
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
     String product_key

     ) {
		super();
		this.product_code = product_code;
		this.description = description;
		this.rem_months = rem_months;
		this.created=created;
		this.updated = updated;
		this.production_date=production_date;
        this.product_group=product_group;
        this.product_name=product_name;
        this.product_serial = product_serial;
        this.no_of_cartons_received=no_of_cartons_received;
        this.product_key = product_key;

	}


    
}
