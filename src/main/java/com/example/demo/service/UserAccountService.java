package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    List<UserAccount> getAllUsers();
    Optional<UserAccount> getUserByEmail(String email);
    Optional<UserAccount> findByUsername(String username);

    // Add these methods to fix controller calls
    UserAccount createUser(UserAccount user);
    Optional<UserAccount> getUserById(Long id);
    UserAccount updateUserStatus(Long id, String status);
}
