package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount getUserById(long id);

    UserAccount updateUserStatus(long id, String status);

    List<UserAccount> getAllUsers();
}
