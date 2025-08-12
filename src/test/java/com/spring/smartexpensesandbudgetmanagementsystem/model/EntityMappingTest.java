package com.spring.smartexpensesandbudgetmanagementsystem.model;

import com.spring.smartexpensesandbudgetmanagementsystem.repository.BudgetRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.CategoryRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.ExpensesRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.UsersRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EntityMappingTest {

    @Autowired
    private BudgetRepo budgetRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ExpensesRepo expensesRepo;

    @Autowired
    private UsersRepo usersRepo;


    Users user;
    Category category;
    Expenses expenses;


    @BeforeEach
    public void beforeEach(){

        user = Users.builder()
                .username("user1")
                .password("nkajhfkjhasufh")
                .role("user")
                .build();

        category = Category.builder()
                .name("food")
                .description("This category covers all the food related expenses, including groceries, Dinning, and fine dine")
                .build();

        expenses = Expenses.builder()
                .amount(1000d)
                .currency("INR")
                .description("This describes the expenses during the last night dinning")
                .users(user)
                .category(category)
                .build();
    }

    @Test
    public void checkMapping(){
        usersRepo.save(user);
        categoryRepo.save(category);
        expensesRepo.save(expenses);

        Expenses foundExpense = expensesRepo.findByUsersUsername(user.getUsername())
                .orElseThrow();

        assertEquals(user.getUsername(), foundExpense.getUsers().getUsername());
        assertNotEquals("someOtherUsername", foundExpense.getUsers().getUsername());
    }

    @Test
    void testFindByUsersUsername_NotFound() {
        assertThrows(NoSuchElementException.class, () -> {
            expensesRepo.findByUsersUsername("somename")
                    .orElseThrow();
        });
    }

    @Test
    void testFindByUsersUsername() {
        assertThrows(NoSuchElementException.class, () -> {
            expensesRepo.findByUsersUsername(user.getUsername())
                    .orElseThrow();
        });
    }
}
