package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository repo,
                                  PasswordEncoder passwordEncoder,
                                  JwtUtil jwtUtil) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public UserAccount login(String username, String password) {
        UserAccount user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user); // keep your existing JwtUtil
        user.setToken(token); // assuming your UserAccount has a token field
        return user;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        user.setStatus(status);
        return repo.save(user);
    }
}
