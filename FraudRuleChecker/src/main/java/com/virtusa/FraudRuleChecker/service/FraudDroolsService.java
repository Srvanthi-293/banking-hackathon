package com.virtusa.FraudRuleChecker.service;

import org.springframework.stereotype.Service;



import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.entity.TransactionDecision;
import com.virtusa.FraudRuleChecker.model.FraudContext;
import com.virtusa.FraudRuleChecker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDroolsService {

    private final KieContainer kieContainer;
    private final TransactionRepository transactionRepository;

    public Transaction evaluateAndSave(Transaction transaction) {

        FraudContext context =
                FraudContext.builder()
                        .transaction(transaction)
                        .build();

        KieSession kieSession =
                kieContainer.newKieSession("fraudSession");

        kieSession.insert(context);

        kieSession.fireAllRules();

        kieSession.dispose();

        transaction.setRiskScore(
                context.getScore());

        transaction.setReasons(
                String.join(", ", context.getReasons()));

        if(context.getScore() <= 30) {

            transaction.setDecision(
                    TransactionDecision.SAFE);

        } else if(context.getScore() <= 60) {

            transaction.setDecision(
                    TransactionDecision.REVIEW);

        } else {

            transaction.setDecision(
                    TransactionDecision.FRAUD);
        }

        return transactionRepository.save(transaction);
    }
}
