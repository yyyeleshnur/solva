package com.example.backend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "currencyClient", url = "https://api.example.com")
public interface CurrencyClient {
    @GetMapping("/exchange-rates")
    Map<String, BigDecimal> getExchangeRates(@RequestParam("base") String base, @RequestParam("symbols") String symbols);
}
