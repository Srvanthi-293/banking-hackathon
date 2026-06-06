package com.virtusa.FraudRuleChecker.rules;



import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.entity.RuleResult;
import com.virtusa.FraudRuleChecker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewPayeeRule implements FraudRule {

    private final TransactionRepository transactionRepository;

    @Override
    public RuleResult evaluate(Transaction txn) {

        boolean existingPayee =
                transactionRepository
                        .existsByCustomerIdAndPayee(
                                txn.getCustomer().getId(),
                                txn.getPayee());

        if(!existingPayee) {

            return RuleResult.builder()
                    .triggered(true)
                    .points(20)
                    .reason("First transaction to this payee")
                    .build();
        }

        return RuleResult.builder()
                .triggered(false)
                .points(0)
                .build();
    }
}
