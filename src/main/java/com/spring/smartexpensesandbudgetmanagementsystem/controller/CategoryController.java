package com.spring.smartexpensesandbudgetmanagementsystem.controller;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.AllCategoryResponseDto;
import com.spring.smartexpensesandbudgetmanagementsystem.dto.SaveCategoryRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Category;
import com.spring.smartexpensesandbudgetmanagementsystem.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper modelmapper;

    @GetMapping("/{name}")
    public AllCategoryResponseDto getCategoryById(@PathVariable String name){
        return modelmapper.map(categoryService.findByName(name).orElseThrow(),AllCategoryResponseDto.class);
    }

    @GetMapping("/allCategory")
    public List<AllCategoryResponseDto> getAllCategory(){
        return categoryService.findAll().stream()
                .map(category -> modelmapper.map(category, AllCategoryResponseDto.class))
                .toList();
    }

    @PostMapping("/category")
    public AllCategoryResponseDto saveCategory(@RequestBody SaveCategoryRequestDto saveCategoryRequestDto){
        return modelmapper.map(categoryService.saveCategory(modelmapper.map(saveCategoryRequestDto,Category.class)), AllCategoryResponseDto.class);
    }

    @DeleteMapping("/{name}")
    @Transactional
    public void deleteByName(@PathVariable String name){
        categoryService.deleteCategoryByName(name);
    }
}
