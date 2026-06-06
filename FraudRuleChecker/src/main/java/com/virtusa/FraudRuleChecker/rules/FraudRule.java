package com.virtusa.FraudRuleChecker.rules;



import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.entity.RuleResult;

public interface FraudRule {

    RuleResult evaluate(Transaction transaction);
}
