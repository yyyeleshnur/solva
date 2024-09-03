package com.example.backend.service;

import com.example.backend.entity.Transaction;
import com.example.backend.repository.TransactionRepository;
import com.example.backend.repository.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private LimitRepository limitRepository;

    public Transaction saveTransaction(Transaction transaction) {
        Optional<Limit> currentLimit = limitRepository.findFirstByOrderByLimitDatetimeDesc();
        if (currentLimit.isPresent()) {
            BigDecimal totalSumInUSD = transaction.getSum(); // Преобразование в USD на основе курса валют
            if (totalSumInUSD.compareTo(currentLimit.get().getLimitSum()) > 0) {
                transaction.setLimitExceeded(true);
            }
        }
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsExceedingLimit() {
        return transactionRepository.findByLimitExceededTrue();
    }
}
