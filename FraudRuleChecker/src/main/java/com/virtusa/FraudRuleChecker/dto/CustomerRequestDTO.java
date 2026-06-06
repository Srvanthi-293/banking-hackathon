package com.virtusa.FraudRuleChecker.dto;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDTO {

    private String name;

    private String homeCity;

    private Double averageTxnAmount;
}
