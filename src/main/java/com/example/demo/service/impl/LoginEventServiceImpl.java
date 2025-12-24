package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;


@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;

    public LoginEventServiceImpl(LoginEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<LoginEvent> getSuspiciousEvents() {
        return repo.findBySuspiciousTrue();
    }
}
