package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount authenticate(String username, String password);


    List<UserAccount> getAllUsers();

    UserAccount updateUserStatus(Long id, String status);

    // For AuthController login
String login(String username, String password);

// For UserAccountController
UserAccount getUserById(Long id);
UserAccount updateStatus(Long id, String status);

}
