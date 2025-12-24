package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        Optional<UserAccount> userOpt = userRepository.findById(id);
        return userOpt.orElse(null);
    }

    @Override
    public UserAccount updateRole(Long id, String role) {
        UserAccount user = getUserById(id);
        if (user != null) {
            user.setRole(role);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        if (user != null) {
            user.setStatus(status);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public UserAccount findByUsername(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
