package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepository;

    public UserAccountServiceImpl(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserAccount updateRole(Long id, String role) {
        UserAccount user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {  // <-- exact interface method name
        UserAccount user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setStatus(status);
        return userRepository.save(user);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}
