package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount createUser(UserAccount user);
    UserAccount getUserById(Long id);
    void updateUserStatus(Long id, String status);
    void deleteUser(Long id);
    UserAccount findByUsername(String username);
    List<UserAccount> getAllUsers();
}
