package com.spring.smartexpensesandbudgetmanagementsystem.security;


import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.UsersRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SmartExpensesAndBudgetManagementSystemUserDetailsService implements UserDetailsService {

    private final UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersService.findByUsername(username).orElseThrow();
        return new User(
                users.getUsername(),
                users.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + users.getRole()))
        );
    }
}
