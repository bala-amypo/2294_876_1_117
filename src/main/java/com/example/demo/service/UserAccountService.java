package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount create(UserAccount user);
    UserAccount updateStatus(Long id, String status);
    List<UserAccount> all();

    // Missing method
    UserAccount findByEmail(String email);

    // Optional: get by ID if used
    UserAccount getUserById(Long id);
}
