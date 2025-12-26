package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {

        // ✅ DEFAULTS — CLIENT DOES NOT SEND THESE
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");
        }

        if (user.getStatus() == null || user.getStatus().isBlank()) {
            user.setStatus("ACTIVE");
        }

        if (user.getEmployeeId() == null || user.getEmployeeId().isBlank()) {
            user.setEmployeeId("EMP-" + UUID.randomUUID().toString().substring(0, 8));
        }

        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }

        return userAccountRepository.save(user);
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return userAccountRepository.findById(id);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(status);
        return userAccountRepository.save(user);
    }
}
