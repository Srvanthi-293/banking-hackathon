package com.virtusa.FraudRuleChecker.repository;


import com.virtusa.FraudRuleChecker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPayeeHistory
        extends JpaRepository<Transaction, Long> {
}
