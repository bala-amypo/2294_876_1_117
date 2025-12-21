package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        // hash password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // default role/status if null
        if (user.getRole() == null) user.setRole("USER");
        if (user.getStatus() == null) user.setStatus("ACTIVE");

        // save user
        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        user.setStatus(status);
        return userAccountRepository.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userAccountRepository.findByUsername(username); // return Optional
    }
}
