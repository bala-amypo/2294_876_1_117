package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        // Check for duplicate username/email
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new BadRequestException("Username already exists");
        }
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}
