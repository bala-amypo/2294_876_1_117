package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount saveUser(UserAccount user) {
        return userRepo.save(user);
    }

    @Override
    public UserAccount findByUsername(String username) {
        // 🔥 FIX IS HERE
        return userRepo.findByUsername(username).orElse(null);
    }

    @Override
    public UserAccount getById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<UserAccount> getAll() {
        return userRepo.findAll();
    }
}
