package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount createUser(UserAccount user);
    UserAccount updateUserStatus(Long id, String status);
    List<UserAccount> getAllUsers();
    UserAccount getUserById(Long id);
}
