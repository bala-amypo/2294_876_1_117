package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    // Constructor injection
    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount create(UserAccount user) {
        return userRepo.save(user);
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id).orElseThrow();
        user.setStatus(status);
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> all() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
