package com.virtusa.FraudRuleChecker.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleResult {

    private boolean triggered;

    private Integer points;

    private String reason;
}
