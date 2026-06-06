package com.virtusa.FraudRuleChecker.entity;

public class Transaction {
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

        private String customerId;

        private Double amount;

        private String payee;

        private LocalDateTime transactionTime;

        private String homeCity;

        private String transactionCity;
    }
}
