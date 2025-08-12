package com.spring.smartexpensesandbudgetmanagementsystem.service;


import com.spring.smartexpensesandbudgetmanagementsystem.dto.SignInRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.dto.SignInResponseDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;

import java.util.Optional;

public interface UsersService {

     SignInResponseDto saveNewUsers(SignInRequestDto signInRequestDto);
     Optional<Users> findByUsername(String username);
     Users saveNewUsers(Users users);
}
