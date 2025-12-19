package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public UserAccount create(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public UserAccount getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return repository.save(user);
        }
        return null;
    }

    @Override
    public List<UserAccount> getAll() {
        return repository.findAll();
    }
}
