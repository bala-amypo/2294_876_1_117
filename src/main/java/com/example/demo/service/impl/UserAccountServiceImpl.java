package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import java.util.List;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    // Constructor injection (no @Autowired)
    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount create(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        UserAccount user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(status);
        return repository.save(user);
    }

    @Override
    public List<UserAccount> all() {
        return repository.findAll();
    }
}
