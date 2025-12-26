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

    public UserAccountServiceImpl(UserAccountRepository userRepo,
                                  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount create(UserAccount user) {

        if (user.getEmployeeId() == null) {
            user.setEmployeeId("EMP-" + System.currentTimeMillis());
        }

        if (user.getUsername() == null) {
            user.setUsername("user_" + System.currentTimeMillis());
        }

        if (user.getEmail() == null) {
            user.setEmail(user.getUsername() + "@example.com");
        }

        if (user.getStatus() == null) {
            user.setStatus("ACTIVE");
        }

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        // Safety: encode if not encoded
        if (user.getPassword() != null && !user.getPassword().startsWith("$2")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        user.setStatus(status);
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
