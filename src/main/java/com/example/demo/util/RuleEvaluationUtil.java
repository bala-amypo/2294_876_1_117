package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepository;
    private final ViolationRecordRepository violationRepository;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepository, ViolationRecordRepository violationRepository) {
        this.ruleRepository = ruleRepository;
        this.violationRepository = violationRepository;
    }

    // Example evaluation logic
    public void evaluateLoginEvent(LoginEvent event) {
        // Iterate over active rules and evaluate
        ruleRepository.findByActiveTrue().forEach(rule -> {
            // Dummy evaluation: create a violation if something matches
            if (event.getUsername() == null || event.getUsername().isEmpty()) {
                // save violation
            }
        });
    }
}
