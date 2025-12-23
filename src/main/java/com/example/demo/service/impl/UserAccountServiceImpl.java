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

    // REQUIRED BY TEST
    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
        this.encoder = null;
    }

    // REQUIRED BY SPRING
    public UserAccountServiceImpl(UserAccountRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        if (encoder != null) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        return repo.save(user);
    }

    @Override
    public UserAccount getUserById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateUserStatus(long id, String status) {
        UserAccount user = repo.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            repo.save(user);
        }
        return user;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
}
