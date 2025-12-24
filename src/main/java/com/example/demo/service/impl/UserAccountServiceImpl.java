package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    // Constructor used by Spring
    public UserAccountServiceImpl(UserAccountRepository userRepo,
                                  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // Constructor used by tests
    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = null;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        if (passwordEncoder != null && user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    // ✅ MUST return UserAccount (NOT Optional)
    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        user.setStatus(status);
        return userRepo.save(user);
    }

    // ✅ REQUIRED by interface
    @Override
    public UserAccount findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
