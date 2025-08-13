package com.spring.smartexpensesandbudgetmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@ToString(exclude = {"expensesList", "budgetList"})
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
    @JsonIgnore
    private List<Expenses> expensesList;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private List<Budget> budgetList;

    @CreatedDate
    @JsonIgnore
    private LocalDate createdAt;
}
