package com.example.backend;

import com.example.backend.entity.Limit;
import com.example.backend.repository.LimitRepository;
import com.example.backend.service.LimitService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class LimitServiceTest {

    @Autowired
    private LimitService limitService;

    @MockBean
    private LimitRepository limitRepository;

    @Test
    public void testSetNewLimit() {
        Limit limit = new Limit();
        limit.setLimitSum(new BigDecimal("1500.00"));

        Mockito.when(limitRepository.save(any(Limit.class))).thenReturn(limit);

        Limit savedLimit = limitService.setNewLimit(new BigDecimal("1500.00"));
        assertNotNull(savedLimit);
    }
}
