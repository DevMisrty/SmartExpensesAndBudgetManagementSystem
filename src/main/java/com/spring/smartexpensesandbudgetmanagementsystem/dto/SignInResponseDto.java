package com.spring.smartexpensesandbudgetmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class SignInResponseDto {

    private Long id;
    private String username;
    private String password;
    private String welcomeMessage = "Thanks for using Smart Expense and Budget Management System";

    @Override
    public String toString() {
        return " User {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", And '" + welcomeMessage + '\'' +
                '}';
    }
}
