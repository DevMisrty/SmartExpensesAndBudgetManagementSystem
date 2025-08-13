package com.spring.smartexpensesandbudgetmanagementsystem.CurrencyExchangeService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService {

    @Value("${CurrencyExchange.api}")
    private String API;

    private final RestTemplate restTemplate;

    public CurrencyExchangeDto getExchangeData(){
        log.info("Before calling external api ");
        ResponseEntity<CurrencyExchangeDto> exchangeData =
                restTemplate.exchange(API, HttpMethod.GET, null, CurrencyExchangeDto.class);

        log.info(exchangeData.toString());
        CurrencyExchangeDto currencyData = exchangeData.getBody();
        log.info(currencyData.toString());
        return currencyData;
    }
}
