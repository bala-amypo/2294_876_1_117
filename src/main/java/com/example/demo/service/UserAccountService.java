package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    String login(String username, String password);
    List<UserAccount> getAllUsers();
    UserAccount updateUserStatus(Long userId, String status);
    UserAccount getUserById(Long id);
}
