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
    public UserAccount getUserById(long id) {
        // Fix Optional -> UserAccount conversion
        return userRepo.findById(id).orElse(null);
        // Or throw exception if not found
        // return userRepo.findById(id)
        //        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return userRepo.save(user);
    }

        @Override
    public UserAccount findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

        @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

      @Override
    public UserAccount saveUser(UserAccount user) {
        return userRepo.save(user);
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

    // Add other implemented methods from UserAccountService interface here
}
