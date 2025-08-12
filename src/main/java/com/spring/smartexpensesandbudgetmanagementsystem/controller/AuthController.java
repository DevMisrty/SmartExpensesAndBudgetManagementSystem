package com.spring.smartexpensesandbudgetmanagementsystem.controller;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.LogInRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.dto.SignInRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import com.spring.smartexpensesandbudgetmanagementsystem.service.UsersService;
import com.spring.smartexpensesandbudgetmanagementsystem.utility.JwtUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UsersService usersService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtility jwtUtility;

    @PostMapping("/signin")
    public ResponseEntity<?> getUserSignIn(@RequestBody SignInRequestDto signInRequestDto){
        try{
             return ResponseEntity.ok( usersService.saveNewUsers(signInRequestDto));
        }catch (Exception ex){
            return new ResponseEntity<>("Pls try again", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> getUserLogIn( @RequestBody LogInRequestDto logInRequestDto){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            logInRequestDto.getUsername(),
                            logInRequestDto.getPassword()
                    )
            );
            Users users = usersService.findByUsername(logInRequestDto.getUsername()).orElseThrow();
            return ResponseEntity.ok(jwtUtility.getAccessToken(users));
        }catch (Exception e){
            return new ResponseEntity<>("Theres some error, Pls try again   " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
