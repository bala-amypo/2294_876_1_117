package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repo,
                                  PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public UserAccount create(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return repo.findByEmail(email);   // ✅ NO orElse
    }

    @Override
    public UserAccount findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = repo.findById(id).orElseThrow();
        user.setStatus(status);
        return repo.save(user);
    }

    @Override
    public List<UserAccount> all() {
        return repo.findAll();
    }
}
