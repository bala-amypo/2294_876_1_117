package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public UserAccount createUser(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public void updateUserStatus(long id, String status) {
        UserAccount user = repository.findById(id).orElseThrow();
        user.setStatus(status);
        repository.save(user);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}
