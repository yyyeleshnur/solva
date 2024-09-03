package com.example.backend.service;

import com.example.backend.client.CurrencyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyClient currencyClient;

    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        return currencyClient.getExchangeRates(fromCurrency, toCurrency).get(toCurrency);
    }
}
