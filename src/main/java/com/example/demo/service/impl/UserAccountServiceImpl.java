package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    // ✅ REQUIRED by interface
    @Override
    public UserAccount createUser(UserAccount user) {
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
        return userRepo.save(user);
    }

    // ✅ FIXED: return type MUST be UserAccount (not Optional)
    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // ✅ REQUIRED by interface (THIS WAS MISSING)
    @Override
    public UserAccount findByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    // ✅ REQUIRED by interface
    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    // ✅ REQUIRED by interface
    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return userRepo.save(user);
        }
        return null;
    }
}
