package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount getUserById(Long id);           // Must return UserAccount, not Optional
    List<UserAccount> getAllUsers();

    UserAccount updateRole(Long userId, String role);

    UserAccount findByUsername(String username); // <-- needed by test cases
}
