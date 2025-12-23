package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.Optional;
import java.util.List;

public interface UserAccountService {

    Optional<UserAccount> findByEmail(String email);
    UserAccount create(UserAccount user);
    UserAccount updateStatus(Long id, String status);
    List<UserAccount> all();
}
