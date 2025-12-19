package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    @Autowired
    private LoginEventRepository repository;

    @Override
    public LoginEvent record(LoginEvent event) {
        return repository.save(event);
    }

    @Override
    public List<LoginEvent> suspicious(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> all() {
        return repository.findAll();
    }
}
