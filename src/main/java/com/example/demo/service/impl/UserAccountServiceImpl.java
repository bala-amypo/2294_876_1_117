package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return repo.save(user);
    }

    // alias for controller
    @Override
    public UserAccount saveUser(UserAccount user) {
        return createUser(user);
    }

    // alias for controller
    @Override
    public UserAccount findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    @Override
    public UserAccount getUserById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateUserStatus(long id, String status) {
        UserAccount user = getUserById(id);
        if (user != null) {
            user.setStatus(status);
            return repo.save(user);
        }
        return null;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
}
