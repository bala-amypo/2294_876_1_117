package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public UserAccount createUser(UserAccount u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    public UserAccount getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = repo.findById(id).orElse(null);
        u.setStatus(status);
        return repo.save(u);
    }

    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
}
