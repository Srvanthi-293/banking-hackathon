package com.virtusa.FraudRuleChecker.dto;



import com.virtusa.FraudRuleChecker.entity.TransactionDecision;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDTO {

    private Long transactionId;

    private Double amount;

    private Integer riskScore;

    private TransactionDecision decision;

    private List<String> reasons;
}
