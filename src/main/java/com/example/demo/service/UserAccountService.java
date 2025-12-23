package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount create(UserAccount user);

    UserAccount getById(Long id);

    List<UserAccount> all();   // 👈 IMPORTANT (not getAll)

    UserAccount updateStatus(Long id, String status);

    UserAccount findByEmail(String email);
}
