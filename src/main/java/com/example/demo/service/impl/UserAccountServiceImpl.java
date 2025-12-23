package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount create(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public List<UserAccount> all() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepo.findByUsername(username); // must return UserAccount, not Optional
    }

    @Override
    public UserAccount findByEmail(String email) {
        return userRepo.findByEmail(email); // must exist in your repo
    }
}
