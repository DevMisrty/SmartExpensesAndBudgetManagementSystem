package com.spring.smartexpensesandbudgetmanagementsystem.repository;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepo extends CrudRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
}
