package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import com.example.demo.util.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(String username, String password) {
        UserAccount user = repo.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setToken(jwtUtil.generateToken(user.getUsername()));
        return user.getToken();
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long userId, String status) {
        UserAccount user = repo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(status);
        return repo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
