package com.spring.smartexpensesandbudgetmanagementsystem.repository;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<Users,Long> {
}
