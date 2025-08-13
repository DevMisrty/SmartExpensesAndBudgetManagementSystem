package com.spring.smartexpensesandbudgetmanagementsystem.controller;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.AddExpensesRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.service.ExpensesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class ExpensesController {

    private final ExpensesService expensesService;

    @PostMapping("/expenses")
    public ResponseEntity<?> addNewExpenses(@RequestBody AddExpensesRequestDto addExpensesRequestDto){
        return new ResponseEntity<>(expensesService.saveNewExpenses(addExpensesRequestDto),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public void deleteExpenses(@PathVariable("id") long id){
        expensesService.deleteExpenseById(id);
    }
}
