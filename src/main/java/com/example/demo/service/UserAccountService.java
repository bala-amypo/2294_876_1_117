package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    Optional<UserAccount> getUserById(Long id);

    List<UserAccount> getAllUsers();

    UserAccount updateStatus(Long id, String status);

    Optional<UserAccount> findByUsername(String username);

    Optional<UserAccount> findByEmail(String email);
}
