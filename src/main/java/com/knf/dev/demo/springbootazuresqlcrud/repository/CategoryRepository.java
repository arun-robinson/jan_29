package com.knf.dev.demo.springbootazuresqlcrud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.knf.dev.demo.springbootazuresqlcrud.entity.Category;

public interface CategoryRepository  extends CrudRepository<Category, Long>  {
    

    @Query("SELECT u FROM Category u WHERE u.category_id = ?1")
    Category get_category_by_id(Long category_id);

}
