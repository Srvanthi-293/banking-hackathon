package com.virtusa.FraudRuleChecker.entity;


import com.virtusa.FraudRuleChecker.entity.TransactionDecision;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Double amount;

    private String payee;

    private LocalDateTime timestamp;

    @Column(name = "transaction_city")
    private String transactionCity;

    private Integer riskScore;

    @Enumerated(EnumType.STRING)
    private TransactionDecision decision;

    @Column(length = 1000)
    private String reasons;
}