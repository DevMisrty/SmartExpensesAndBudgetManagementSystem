package com.spring.smartexpensesandbudgetmanagementsystem.CurrencyExchangeService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CurrencyExchangeDto {

    public String result;
    public String base_code;
    public ConversionRates conversion_rates;

    @Data
    @NoArgsConstructor @AllArgsConstructor
    class ConversionRates{
        @JsonProperty("USD")
        public int uSD;
        @JsonProperty("AUD")
        public double aUD;
        @JsonProperty("BGN")
        public double bGN;
    }
}


