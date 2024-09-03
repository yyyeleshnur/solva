package com.example.backend.service;

import com.example.backend.entity.Limit;
import com.example.backend.repository.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class LimitService {

    @Autowired
    private LimitRepository limitRepository;

    public Limit setNewLimit(BigDecimal limitSum) {
        Limit newLimit = new Limit();
        newLimit.setLimitSum(limitSum);
        newLimit.setLimitDatetime(LocalDateTime.now());
        return limitRepository.save(newLimit);
    }
}
