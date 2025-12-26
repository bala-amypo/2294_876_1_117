package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    Optional<UserAccount> findByEmail(String email);

    Optional<UserAccount> findByUsername(String username);

    List<UserAccount> getAllUsers();

    UserAccount updateUserStatus(Long id, String status);

    UserAccount getUserById(Long id);
}
