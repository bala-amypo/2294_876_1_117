package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    // ✅ CONSTRUCTOR USED BY SPRING / TESTS
    public UserAccountServiceImpl(UserAccountRepository userRepo,
                                  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ CONSTRUCTOR USED BY TESTS THAT PASS ONLY REPO
    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = null; // ✅ REQUIRED to satisfy Java final rule
    }

    // ================= EXISTING LOGIC (UNCHANGED) =================

    @Override
    public UserAccount createUser(UserAccount user) {
        if (passwordEncoder != null && user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(status);
        return userRepo.save(user);
    }
}
