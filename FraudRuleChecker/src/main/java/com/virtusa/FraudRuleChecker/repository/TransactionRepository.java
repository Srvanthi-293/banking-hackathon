package com.virtusa.FraudRuleChecker.repository;



import com.virtusa.FraudRuleChecker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // New Payee Rule
    boolean existsByCustomerIdAndPayee(Long customerId, String payee);

    // Velocity Rule
    List<Transaction> findByCustomerIdAndTimestampBetween(
            Long customerId,
            LocalDateTime startTime,
            LocalDateTime endTime
    );

    // Spending Baseline Rule
    List<Transaction> findByCustomerId(Long customerId);
}
