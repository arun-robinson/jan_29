package com.knf.dev.demo.springbootazuresqlcrud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

 

import com.knf.dev.demo.springbootazuresqlcrud.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.user_id = ?1 and u.password = ?2")
    User login(String user_id, String password);
}
