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
public UserAccount getUserById(long id) {
    // Correctly unwrap Optional
    return userRepo.findById(id).orElse(null);
}


    @Override
    public UserAccount updateUserStatus(long id, String status) {
        Optional<UserAccount> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserAccount user = optionalUser.get();
            user.setStatus(status);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public UserAccount saveUser(UserAccount user) {
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
}
