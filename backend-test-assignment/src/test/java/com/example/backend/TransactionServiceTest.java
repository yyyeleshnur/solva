package com.example.backend;

import com.example.backend.entity.Transaction;
import com.example.backend.repository.TransactionRepository;
import com.example.backend.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    public void testTransactionExceedsLimit() {
        Transaction transaction = new Transaction();
        transaction.setSum(new BigDecimal("1200.00"));

        Mockito.when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        assertTrue(savedTransaction.isLimitExceeded());
    }
}
