package com.example.backend.controller;

import com.example.backend.entity.Limit;
import com.example.backend.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/limits")
public class LimitController {

    @Autowired
    private LimitService limitService;

    @PostMapping
    public ResponseEntity<Limit> setLimit(@RequestParam BigDecimal limitSum) {
        return ResponseEntity.ok(limitService.setNewLimit(limitSum));
    }
}
