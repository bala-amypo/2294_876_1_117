package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount register(UserAccount user);

    UserAccount getUserById(Long id);

    List<UserAccount> getAllUsers();

    UserAccount updateUserStatus(Long id, String status);
}
