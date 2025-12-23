package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveUser(UserAccount user) {
        repository.save(user);
    }

    @Override
    public void updateUserStatus(long userId, String status) {
        UserAccount user = repository.findById(userId).orElse(null);
        if (user != null) {
            user.setStatus(status);
            repository.save(user);
        }
    }

    @Override
    public UserAccount getUserById(long userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }
}
