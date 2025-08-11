package com.spring.smartexpensesandbudgetmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class Budget {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amountLimit;
    private LocalDate endDate;

    @CreatedDate
    private LocalDate createdAt;
}
