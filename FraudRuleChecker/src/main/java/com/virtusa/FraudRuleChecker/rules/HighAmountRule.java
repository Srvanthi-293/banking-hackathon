package com.virtusa.FraudRuleChecker.rules;

import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.entity.RuleResult;

import org.springframework.stereotype.Component;

@Component
public class HighAmountRule implements FraudRule {

    @Override
    public RuleResult evaluate(Transaction txn) {

        if(txn.getAmount() > 50000) {

            return RuleResult.builder()
                    .triggered(true)
                    .points(30)
                    .reason("Amount exceeds ₹50,000")
                    .build();
        }

        return RuleResult.builder()
                .triggered(false)
                .points(0)
                .build();
    }
}
