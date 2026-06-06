package com.virtusa.FraudRuleChecker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_payee_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerPayeeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;

    private String payee;
}
