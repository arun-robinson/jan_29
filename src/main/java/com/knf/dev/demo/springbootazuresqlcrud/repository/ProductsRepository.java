package com.knf.dev.demo.springbootazuresqlcrud.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.knf.dev.demo.springbootazuresqlcrud.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, Long>  {

    @Query("SELECT u FROM Products u WHERE u.product_id = ?1")
    Products get_product_by_id( Long product_id);
    
}
