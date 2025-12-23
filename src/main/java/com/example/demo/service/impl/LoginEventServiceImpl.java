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
    public List<LoginEvent> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getUserId().equals(userId) && e.isSuspicious())
                .collect(Collectors.toList());
    }
}
