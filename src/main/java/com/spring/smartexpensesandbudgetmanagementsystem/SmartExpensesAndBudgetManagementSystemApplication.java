package com.spring.smartexpensesandbudgetmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SmartExpensesAndBudgetManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartExpensesAndBudgetManagementSystemApplication.class, args);
    }

}
