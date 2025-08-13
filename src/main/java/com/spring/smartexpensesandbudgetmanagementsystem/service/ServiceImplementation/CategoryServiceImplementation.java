package com.spring.smartexpensesandbudgetmanagementsystem.service.ServiceImplementation;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Category;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.CategoryRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public Optional<Category> findByName(String name) {
        return  categoryRepo.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategoryByName(String name) {
        categoryRepo.deleteByName(name);
    }
}
