package com.knf.dev.demo.springbootazuresqlcrud.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import com.knf.dev.demo.springbootazuresqlcrud.entity.Stock;


public interface StockRepository  extends CrudRepository<Stock, Integer>  {

    @Query("SELECT u FROM Stock u WHERE u.product_key = :product_key")
    Stock get_stock_by_id(@Param("product_key")  String product_key);


    
    @Modifying
    @Query("UPDATE Stock u SET u.number_of_cartons_received = :number_of_cartons_received WHERE u.product_key = :product_key")
    Integer update_stock_count(@Param("product_key")  String product_key,@Param("number_of_cartons_received")  int number_of_cartons_received);
    
}
