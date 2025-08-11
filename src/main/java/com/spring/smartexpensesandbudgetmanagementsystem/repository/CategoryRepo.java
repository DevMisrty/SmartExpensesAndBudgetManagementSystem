package com.spring.smartexpensesandbudgetmanagementsystem.repository;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Long>{
}
