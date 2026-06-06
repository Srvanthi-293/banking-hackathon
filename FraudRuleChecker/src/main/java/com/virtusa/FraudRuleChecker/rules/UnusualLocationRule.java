package com.virtusa.FraudRuleChecker.rules;

import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.entity.RuleResult;
import org.springframework.stereotype.Component;

@Component
public class UnusualLocationRule implements FraudRule {

    @Override
    public RuleResult evaluate(Transaction txn) {

        String homeCity =
                txn.getCustomer().getHomeCity();

        if(!homeCity.equalsIgnoreCase(
                txn.getTransactionCity())) {

            return RuleResult.builder()
                    .triggered(true)
                    .points(25)
                    .reason("Transaction city differs from customer's home city")
                    .build();
        }

        return RuleResult.builder()
                .triggered(false)
                .points(0)
                .build();
    }
}
