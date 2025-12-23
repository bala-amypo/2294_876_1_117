package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount create(UserAccount user);              // <-- test expects 'create'
    UserAccount updateStatus(Long id, String status); // <-- test expects 'updateStatus'
    List<UserAccount> all();                           // <-- test expects 'all'
    UserAccount findByUsername(String username);      // <-- must return UserAccount (not Optional)
    UserAccount findByEmail(String email);            // <-- must return UserAccount
}
