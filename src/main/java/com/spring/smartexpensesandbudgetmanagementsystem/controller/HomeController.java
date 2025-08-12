package com.spring.smartexpensesandbudgetmanagementsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String getHome(){
        return "this is a public home page";
    }

    @GetMapping("/users/home")
    public String getUsersHome(){
        return "This is an users home page,";
    }

    @GetMapping("/admin/home")
    public String getAdminPage(){
        return "This is an admin home page";
    }
}
