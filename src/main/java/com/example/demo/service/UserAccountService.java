package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    List<UserAccount> getAllUsers();
    Optional<UserAccount> getUserByEmail(String email);
    Optional<UserAccount> findByUsername(String username); // Make sure this is in the interface
}
