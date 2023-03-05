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

    @Column(name = "attribute1")
    private String attribute1;

    
    @Column(name = "attribute2")
    private String attribute2;

    @Column(name = "attribute3")
    private String attribute3;

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

    public String getAttribute1() {
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }



    public Products() {
		super();
	}

    
	
    public Products( String product_code,  String description,
     int rem_days,
     int rem_months,
     Date created,
     Date updated,
     String attribute1,
     String attribute2,
     String attribute3) {
		super();
		this.product_code = product_code;
		this.description = description;
		this.rem_months = rem_months;
		this.created=created;
		this.updated = updated;
		this.attribute1=attribute1;
        this.attribute2=attribute2;
        this.attribute3=attribute3;
	}


    
}
