package com.virtusa.FraudRuleChecker.repository;



import com.virtusa.FraudRuleChecker.entity.FraudRuleConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRuleConfigRepository extends JpaRepository<FraudRuleConfig, Long> {
}
