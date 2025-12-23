package com.example.demo.service.impl;

import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    @Override
    public List<String> getSuspiciousLogins(Long userId) {
        return Collections.emptyList();
    }
}
