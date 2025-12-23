package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount saveUser(UserAccount user) {
        return repo.save(user);
    }

    @Override
    public UserAccount updateUserStatus(long id, String status) {
        Optional<UserAccount> optional = repo.findById(id);
        if (optional.isPresent()) {
            UserAccount user = optional.get();
            user.setStatus(status);
            return repo.save(user);
        }
        return null;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
    @Override
public UserAccount getUserById(long id) {
    return userRepo.findById(id).orElse(null);
}

}
