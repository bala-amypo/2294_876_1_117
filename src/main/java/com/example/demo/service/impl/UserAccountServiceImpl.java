package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepository;

    public UserAccountServiceImpl(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public UserAccount create(UserAccount user) {
        return userRepository.save(user);
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(status);
        return userRepository.save(user);
    }

    @Override
    public List<UserAccount> all() {
        return userRepository.findAll();
    }
}
