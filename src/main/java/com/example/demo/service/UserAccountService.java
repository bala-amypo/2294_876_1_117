package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    Optional<UserAccount> findByUsername(String username);

    List<UserAccount> getAllUsers();

    Optional<UserAccount> getUserById(Long id);

    String updateUserStatus(Long id, String status);
}
