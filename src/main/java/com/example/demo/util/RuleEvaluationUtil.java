package com.example.demo.util;

import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;

    // ✅ THIS CONSTRUCTOR IS REQUIRED
    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }

    // example method (keep your logic here)
    public boolean evaluate(String input) {
        // TODO: your rule logic
        return true;
    }
}
