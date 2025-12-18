package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount create(UserAccount user);

    UserAccount getUser(Long id);

    UserAccount updateStatus(Long id, String status);

    List<UserAccount> getAll();
}
