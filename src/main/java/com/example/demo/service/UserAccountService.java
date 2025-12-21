package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount getUserById(long id);
    List<UserAccount> getAllUsers();

    // add these for AuthController / UserAccountController
    UserAccount createUser(UserAccount user);
    UserAccount findByUsername(String username);
}
