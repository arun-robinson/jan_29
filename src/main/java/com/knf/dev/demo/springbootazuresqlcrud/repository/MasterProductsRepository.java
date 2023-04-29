package com.knf.dev.demo.springbootazuresqlcrud.repository;
import org.springframework.data.repository.CrudRepository;

import com.knf.dev.demo.springbootazuresqlcrud.entity.MasterProducts;

    


public interface MasterProductsRepository extends CrudRepository<MasterProducts, Long> {

     
}