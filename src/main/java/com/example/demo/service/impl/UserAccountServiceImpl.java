package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return userRepo.save(user);
    }

    @Override
    public UserAccount updateUserStatus(long userId, String status) {
        Optional<UserAccount> optUser = userRepo.findById(userId);
        if (optUser.isPresent()) {
            UserAccount user = optUser.get();
            user.setStatus(status);
            return userRepo.save(user);
        }
        throw new RuntimeException("User not found with ID: " + userId);
    }

    @Override
    public UserAccount saveUser(UserAccount user) {
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }
}
