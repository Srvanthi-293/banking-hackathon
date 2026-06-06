package com.virtusa.FraudRuleChecker.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequestDTO {

    private Long customerId;

    private Double amount;

    private String payee;

    private LocalDateTime timestamp;

    private String transactionCity;
}
