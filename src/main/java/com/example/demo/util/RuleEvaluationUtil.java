package com.example.demo.util;

import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;

    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }

    public boolean evaluate(String input) {
        return true;
    }
}
