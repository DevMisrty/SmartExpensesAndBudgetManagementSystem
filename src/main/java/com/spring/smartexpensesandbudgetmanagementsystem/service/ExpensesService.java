package com.spring.smartexpensesandbudgetmanagementsystem.service;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.AddExpensesRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Expenses;

import java.util.List;

public interface ExpensesService {

    Expenses saveNewExpenses(AddExpensesRequestDto expenses);
    List<Expenses> getAllExpenses();
    void deleteExpenseById(long id);
}
