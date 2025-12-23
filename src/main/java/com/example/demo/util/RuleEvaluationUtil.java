package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component  // <-- Add this annotation
public class RuleEvaluationUtil {

    public RuleEvaluationUtil() {
        // constructor
    }

    // Example method
    public boolean evaluateSomeRule(Object event) {
        // your logic
        return true;
    }
}
