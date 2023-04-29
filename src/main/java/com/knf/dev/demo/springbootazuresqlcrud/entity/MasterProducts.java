package com.knf.dev.demo.springbootazuresqlcrud.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product_master")
public class MasterProducts {
    
	@Id

	@Column(name = "product_code")
    private int productCode;

	@Column(name = "description")
    private String description;

	@Column(name = "category_id")
    private int categoryId;

	@Column(name = "category_name")
    private String categoryName;

	@Column(name = "shelf_life_days")
    private Double shelfLifeDays;

	@Column(name = "shelf_life_months")
    private Double shelfLifeMonths;


	public int getProductCode() {
		return this.productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getShelfLifeDays() {
		return this.shelfLifeDays;
	}

	public void setShelfLifeDays(Double shelfLifeDays) {
		this.shelfLifeDays = shelfLifeDays;
	}

	public Double getShelfLifeMonths() {
		return this.shelfLifeMonths;
	}

	public void setShelfLifeMonths(Double shelfLifeMonths) {
		this.shelfLifeMonths = shelfLifeMonths;
	}

	public MasterProducts() {
		super();
	}


    public MasterProducts(int productCode, String description, int categoryId, String categoryName, double shelfLifeDays, double shelfLifeMonths) {
        
		super();

		this.productCode = productCode;
        this.description = description;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.shelfLifeDays = shelfLifeDays;
        this.shelfLifeMonths = shelfLifeMonths;
    }


    

}
