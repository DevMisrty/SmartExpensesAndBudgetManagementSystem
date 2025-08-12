package com.spring.smartexpensesandbudgetmanagementsystem.controller;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.UpdateUserRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import com.spring.smartexpensesandbudgetmanagementsystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserProfileUpdateController {

    private final UsersService usersService;

    @PostMapping("/updateuser")
    public Users updateUserProfile(@RequestBody UpdateUserRequestDto userRequestDto){
        String username  = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
        Users users = usersService.findByUsername(username).orElseThrow();
        users.setUserDescription(userRequestDto.getUserDescription());
        return usersService.saveNewUsers(users);
    }
}
