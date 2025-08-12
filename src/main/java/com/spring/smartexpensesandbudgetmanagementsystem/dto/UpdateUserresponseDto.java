package com.spring.smartexpensesandbudgetmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UpdateUserresponseDto {

    private Long id;
    private String username;
    private String userDescription;
    private LocalDate createdBy;
    private String messgae;
}
