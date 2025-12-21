package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService {

    UserAccount save(UserAccount user);

    // ✅ required by AuthController
    UserAccount createUser(UserAccount user);

    // ✅ required by AuthController
    Optional<UserAccount> findByUsername(String username);
}
