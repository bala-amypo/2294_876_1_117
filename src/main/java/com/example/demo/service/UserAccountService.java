package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    // MAIN method used internally
    UserAccount create(UserAccount user);

    // METHOD REQUIRED BY TESTS
    default UserAccount createUser(UserAccount user) {
        return create(user);
    }

    UserAccount getUserById(Long id);

    UserAccount updateUserStatus(Long id, String status);

    List<UserAccount> getAllUsers();

    Optional<UserAccount> findByUsername(String username);

    Optional<UserAccount> findByEmail(String email);
}
