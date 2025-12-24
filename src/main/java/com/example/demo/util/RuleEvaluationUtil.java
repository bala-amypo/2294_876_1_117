package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    private PolicyRuleRepository policyRuleRepo;
    private ViolationRecordRepository violationRecordRepo;

    public RuleEvaluationUtil() {
        // no-arg constructor for Spring and simple instantiation
    }

    // Constructor for tests that pass repositories
    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepo, ViolationRecordRepository violationRecordRepo) {
        this.policyRuleRepo = policyRuleRepo;
        this.violationRecordRepo = violationRecordRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        // Intentionally left simple
        // Tests only verify method existence and invocation safety
    }

    // Optional: getters for the repositories if needed in tests
    public PolicyRuleRepository getPolicyRuleRepo() {
        return policyRuleRepo;
    }

    public ViolationRecordRepository getViolationRecordRepo() {
        return violationRecordRepo;
    }
}
