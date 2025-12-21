package com.example.demo.service.impl;

import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;

    public LoginEventServiceImpl(LoginEventRepository loginRepo) {
        this.loginRepo = loginRepo;
    }
}
