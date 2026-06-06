package com.virtusa.FraudRuleChecker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDTO {

    private Long id;

    private String name;

    private String homeCity;

    private Double averageTxnAmount;
}
