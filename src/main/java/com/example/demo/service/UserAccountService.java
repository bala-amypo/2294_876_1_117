package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount createUser(UserAccount user);
    UserAccount getUserById(Long id);
    UserAccount updateRole(Long id, String role);
    UserAccount updateUserStatus(Long id, String status);
    UserAccount findByUsername(String username);
    List<UserAccount> getAllUsers();
}
