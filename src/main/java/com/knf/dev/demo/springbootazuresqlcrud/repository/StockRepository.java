package com.knf.dev.demo.springbootazuresqlcrud.repository;
import org.springframework.data.repository.CrudRepository;

import com.knf.dev.demo.springbootazuresqlcrud.entity.Stock;

public interface StockRepository  extends CrudRepository<Stock, Long>  {
    
}
