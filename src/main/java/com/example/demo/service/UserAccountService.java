package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    String login(String username, String password); // added for AuthController

    UserAccount getUserById(Long id); // added for UserAccountController

    UserAccount updateStatus(Long id, String status); // added for UserAccountController

    UserAccount updateUserStatus(Long id, String status); // added for tests

    List<UserAccount> getAllUsers();
}
