package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount create(UserAccount user) {
        return repo.save(user);
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = repo.findById(id).orElseThrow();
        user.setStatus(status);
        return repo.save(user);
    }

    @Override
    public List<UserAccount> all() {
        return repo.findAll();
    }

    // 🔴 ADD THIS
    @Override
    public UserAccount findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}
