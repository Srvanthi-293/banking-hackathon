package com.virtusa.FraudRuleChecker.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "home_city")
    private String homeCity;

    @Column(name = "average_txn_amount")
    private Double averageTxnAmount;
}