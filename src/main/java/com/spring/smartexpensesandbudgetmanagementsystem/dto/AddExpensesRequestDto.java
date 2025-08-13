package com.spring.smartexpensesandbudgetmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AddExpensesRequestDto {

    private String category;
    private Double amount;
    private String currency;
    private String description;

    @CreatedDate
    private LocalDate date;
}
