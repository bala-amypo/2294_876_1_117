package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    public UserAccount createUser(UserAccount user) {
        return user;
    }

    public UserAccount getUserById(long id) {
        return new UserAccount();
    }

    public UserAccount updateUserStatus(long id, String status) {
        return new UserAccount();
    }

    public List<UserAccount> getAllUsers() {
        return new ArrayList<>();
    }

    public UserAccount findByUsername(String username) {
        return new UserAccount();
    }

    public UserAccount findByEmail(String email) {
        return new UserAccount();
    }
}
