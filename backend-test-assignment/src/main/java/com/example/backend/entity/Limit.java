package com.example.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Limit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal limitSum;
    private String limitCurrencyShortname;
    private LocalDateTime limitDatetime;

    // Getters and Setters
}
