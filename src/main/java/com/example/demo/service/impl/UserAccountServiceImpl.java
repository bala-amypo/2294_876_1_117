package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Override
    public UserAccount create(UserAccount user) {
        return user;
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return Optional.of(new UserAccount());
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return new ArrayList<>();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        return new UserAccount();
    }
}
