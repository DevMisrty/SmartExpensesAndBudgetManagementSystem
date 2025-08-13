package com.spring.smartexpensesandbudgetmanagementsystem.controller;

import com.spring.smartexpensesandbudgetmanagementsystem.CurrencyExchangeService.CurrencyExchangeDto;
import com.spring.smartexpensesandbudgetmanagementsystem.CurrencyExchangeService.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyExchnageController {

    private final CurrencyService currencyService;

    @GetMapping("/getdata")
    public CurrencyExchangeDto getCurrencyExchangeData(){
        System.out.println("=== Inside Controller ===");
        return currencyService.getExchangeData();
    }
}
