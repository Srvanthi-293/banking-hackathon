package com.virtusa.FraudRuleChecker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rule_config")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudRuleConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer highAmountThreshold;

    private Integer highAmountPoints;

    private Integer newPayeePoints;

    private Integer oddHourPoints;

    private Integer unusualLocationPoints;

    private Integer reviewThreshold;

    private Integer fraudThreshold;
}
