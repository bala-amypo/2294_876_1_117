package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    void updateUserStatus(long id, String status);

    UserAccount findByUsername(String username);
}
