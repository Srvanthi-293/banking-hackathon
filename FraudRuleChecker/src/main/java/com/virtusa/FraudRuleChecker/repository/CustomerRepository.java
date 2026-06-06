package com.virtusa.FraudRuleChecker.repository;



import com.virtusa.FraudRuleChecker.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}