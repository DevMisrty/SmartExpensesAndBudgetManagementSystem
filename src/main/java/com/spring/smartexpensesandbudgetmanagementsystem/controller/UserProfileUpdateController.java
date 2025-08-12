package com.spring.smartexpensesandbudgetmanagementsystem.controller;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.ChangePasswordRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.dto.UpdateUserRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.dto.UpdateUserresponseDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import com.spring.smartexpensesandbudgetmanagementsystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserProfileUpdateController {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @PostMapping("/updateuser")
    public UpdateUserresponseDto updateUserProfile(@RequestBody UpdateUserRequestDto userRequestDto){
        String username  = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
        Users users = usersService.findByUsername(username).orElseThrow();
        users.setUserDescription(userRequestDto.getUserDescription());
        UpdateUserresponseDto res = modelMapper.map(usersService.saveNewUsers(users), UpdateUserresponseDto.class);
        res.setMessgae("Your User Description has been changed successfully");
        return res;
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changeUserPassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto){
        String username  = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
        Users users = usersService.findByUsername(username).orElseThrow();
        if(passwordEncoder.matches(changePasswordRequestDto.getPassword(), users.getPassword())){
            return new ResponseEntity<>("Your old password is the new password", HttpStatus.BAD_REQUEST);
        }
        users.setPassword(passwordEncoder.encode(changePasswordRequestDto.getPassword()));
        UpdateUserresponseDto res = modelMapper.map(usersService.saveNewUsers(users), UpdateUserresponseDto.class);
        res.setMessgae("Your password has been changed successfully..");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
