package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    UserAccount createUser(UserAccount user);
    UserAccount getUserById(Long id);  // Must match impl
    UserAccount updateUserStatus(Long id, String status);
    List<UserAccount> getAllUsers();
    UserAccount findByUsername(String username);  // Return type UserAccount, not Optional
}
