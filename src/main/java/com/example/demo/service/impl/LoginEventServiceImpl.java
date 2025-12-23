package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repository;

    public LoginEventServiceImpl(LoginEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        return repository.save(event);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .filter(LoginEvent::getSuspicious) // 🔴 FIXED HERE
                .collect(Collectors.toList());
    }
}
