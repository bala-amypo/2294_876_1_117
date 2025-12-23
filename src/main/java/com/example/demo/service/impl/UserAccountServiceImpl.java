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
    public UserAccount create(UserAccount user) {
        return userRepo.save(user);
    }

    @Override
    public UserAccount updateStatus(Long id, Boolean active) {
        UserAccount user = userRepo.findById(id).orElseThrow();
        user.setActive(active); // ✅ FIXED
        return userRepo.save(user);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null); // ✅ FIXED
    }

    @Override
    public List<UserAccount> findAll() {
        return userRepo.findAll();
    }
}
