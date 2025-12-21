package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount getUserById(long id) {
        return new UserAccount(); // dummy
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return new ArrayList<>();
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return user; // dummy
    }

    @Override
    public UserAccount findByUsername(String username) {
        return new UserAccount(); // dummy
    }
}
