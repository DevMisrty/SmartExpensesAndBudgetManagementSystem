package com.spring.smartexpensesandbudgetmanagementsystem.repository;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses,Long> {

    Optional<Expenses> findByUsersUsername(String username);
}
