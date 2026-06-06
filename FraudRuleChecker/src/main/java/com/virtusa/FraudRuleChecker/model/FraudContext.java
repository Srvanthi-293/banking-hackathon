package com.virtusa.FraudRuleChecker.model;


import com.virtusa.FraudRuleChecker.entity.Transaction;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudContext {

    private Transaction transaction;

    @Builder.Default
    private Integer score = 0;

    @Builder.Default
    private List<String> reasons = new ArrayList<>();
}
