package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount create(UserAccount user);

    UserAccount updateStatus(Long id, String status);

    List<UserAccount> all();

    // Add this method to match your controller usage
    UserAccount findByUsername(String username);

    // Add missing method to match error
    UserAccount findByEmail(String email);
}
