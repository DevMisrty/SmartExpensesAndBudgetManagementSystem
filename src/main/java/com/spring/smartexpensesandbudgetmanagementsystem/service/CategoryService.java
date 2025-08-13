package com.spring.smartexpensesandbudgetmanagementsystem.service;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findByName(String name);
    List<Category> findAll();
    Category saveCategory(Category category);
    void deleteCategoryByName(String name);
}
