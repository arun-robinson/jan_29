package com.knf.dev.demo.springbootazuresqlcrud.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.knf.dev.demo.springbootazuresqlcrud.entity.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>  {
    

    @Query("SELECT u FROM Expense u WHERE u.user_id = ?1")
    Expense get_user_expenses(String user_id);


}
