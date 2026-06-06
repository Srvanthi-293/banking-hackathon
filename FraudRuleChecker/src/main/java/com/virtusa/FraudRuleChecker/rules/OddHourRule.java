package com.virtusa.FraudRuleChecker.rules;

import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.entity.RuleResult;
import org.springframework.stereotype.Component;

@Component
public class OddHourRule implements FraudRule {

    @Override
    public RuleResult evaluate(Transaction txn) {

        int hour = txn.getTimestamp().getHour();

        if(hour >= 1 && hour <= 4) {

            return RuleResult.builder()
                    .triggered(true)
                    .points(15)
                    .reason("Transaction occurred between 1 AM and 4 AM")
                    .build();
        }

        return RuleResult.builder()
                .triggered(false)
                .points(0)
                .build();
    }
}
