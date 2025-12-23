package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;

    public LoginEventServiceImpl(LoginEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        return repo.save(event); // must return the saved entity
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repo.findByUserIdAndSuspiciousTrue(userId);
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
    }
}
