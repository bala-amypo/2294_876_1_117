package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService {

    Optional<UserAccount> findByEmail(String email);

    UserAccount getUserById(Long id);
}
