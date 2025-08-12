package com.spring.smartexpensesandbudgetmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UpdateUserRequestDto {

    private String userDescription;
}
