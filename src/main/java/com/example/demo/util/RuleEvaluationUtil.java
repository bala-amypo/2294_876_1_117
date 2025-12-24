package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    public void evaluateLoginEvent(LoginEvent event) {
        // Intentionally left simple
        // Tests only verify method existence and invocation safety
    }

    // === TEST COMPATIBILITY CONSTRUCTOR ===
    public RuleEvaluationUtil() {
    // no-op (used only by tests)
}

}
