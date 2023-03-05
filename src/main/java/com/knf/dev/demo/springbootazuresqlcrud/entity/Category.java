package com.knf.dev.demo.springbootazuresqlcrud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Category")
public class Category {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_id;
    
    @Column(name = "category_code")
    private String category_code;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public Long getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_code() {
        return this.category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    
    public Category() {
		super();
	}


    
    public Category(
     
     String category_code,
     Date created,
     Date updated
     ) {
		super();
		 
		this.category_code = category_code;
		this.created = created;
		this.updated=updated;
		 
	}

}
