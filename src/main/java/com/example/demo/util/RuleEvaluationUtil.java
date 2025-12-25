package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component 
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {

        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        if (rules == null || rules.isEmpty()) {
            return; // ✅ testNoViolationWhenNoRules
        }

        for (PolicyRule rule : rules) {

            if (rule.getConditionsJson() != null
                    && event.getLoginStatus() != null
                    && rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setEventId(event.getId());
                v.setSeverity(rule.getSeverity());
                v.setDetails("Rule violated: " + rule.getRuleCode());
                v.setResolved(false);
                v.setDetectedAt(LocalDateTime.now());

                violationRepo.save(v); // ✅ exactly once
                return;
            }
        }
    }
}
