package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

public class RuleEvaluationUtil {

    private PolicyRuleRepository policyRuleRepository;
    private ViolationRecordRepository violationRecordRepository;

    public RuleEvaluationUtil() {
    }

    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository,
                              ViolationRecordRepository violationRecordRepository) {
        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    public boolean evaluateLoginEvent(LoginEvent loginEvent) {
        return true;
    }
}
