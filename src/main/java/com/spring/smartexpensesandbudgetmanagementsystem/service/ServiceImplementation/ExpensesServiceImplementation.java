package com.spring.smartexpensesandbudgetmanagementsystem.service.ServiceImplementation;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.AddExpensesRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Category;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Expenses;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.ExpensesRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.UsersRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.service.CategoryService;
import com.spring.smartexpensesandbudgetmanagementsystem.service.ExpensesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ExpensesServiceImplementation implements ExpensesService {

    private final ExpensesRepo expensesRepo;
    private final UsersRepo usersRepo;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Override
    public Expenses saveNewExpenses(AddExpensesRequestDto addExpensesRequestDto) {
        Expenses expenses = modelMapper.map(addExpensesRequestDto, Expenses.class);
        log.info(expenses.toString());
        String username = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal().toString();
        Users users = usersRepo.findByUsername(username).orElseThrow();
        log.info(users.toString());
        Category category = categoryService.findByName(addExpensesRequestDto.getCategory()).orElseThrow();
        expenses.setCategory(category);
        expenses.setUsers(users);

        log.info(expenses.toString());
        return expensesRepo.save(expenses);
    }

    @Override
    public List<Expenses> getAllExpenses() {
       return expensesRepo.findAll();
    }

    @Override
    public void deleteExpenseById(long id) {
        expensesRepo.deleteById(id);
    }
}
