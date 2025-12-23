package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;
    private final ViolationRecordService violationService;

    // EXISTING constructor
    public RuleEvaluationUtil(ViolationRecordService violationService) {
        this.violationService = violationService;
        this.ruleRepo = null;
        this.violationRepo = null;
    }

    // ✅ NEW constructor for test
    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
        this.violationService = null;
    }

    // ✅ Overloaded evaluateLoginEvent for test
    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = ruleRepo != null ? ruleRepo.findByActiveTrue() : List.of();
        evaluateLoginEvent(event, rules);
    }

    // EXISTING
    public void evaluateLoginEvent(LoginEvent event, List<PolicyRule> activeRules) {
        // your existing logic
    }
}
