package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    // ✅ REQUIRED constructor (matches Mockito test)
    public UserAccountServiceImpl(UserAccountRepository userRepo,
                                  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // ------------------------------------------------
    // CREATE USER
    // ------------------------------------------------
    @Override
    public UserAccount createUser(UserAccount user) {

        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        if (user.getStatus() == null) {
            user.setStatus("ACTIVE");
        }

        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }

        return userRepo.save(user);
    }

    // ------------------------------------------------
    // GET USER BY ID
    // ------------------------------------------------
    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // ------------------------------------------------
    // UPDATE USER STATUS
    // ------------------------------------------------
    @Override
    public UserAccount updateUserStatus(Long id, String status) {

        UserAccount user = userRepo.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setStatus(status);
        return userRepo.save(user);
    }

    // ------------------------------------------------
    // GET ALL USERS
    // ------------------------------------------------
    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}
