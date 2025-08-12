package com.spring.smartexpensesandbudgetmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String role;

    private String userDescription;

    @OneToMany(mappedBy ="users")
    private List<Expenses> expensesList;

    @OneToMany(mappedBy = "users")
    private List<Budget> budgetList;

    @CreatedDate
    private LocalDate createdAt;
}
