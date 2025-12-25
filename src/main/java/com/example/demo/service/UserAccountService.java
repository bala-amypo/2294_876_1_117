package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount authenticate(String username, String password);

    UserAccount getById(Long id);

    List<UserAccount> getAllUsers();

    UserAccount updateUserStatus(Long id, String status);
}
