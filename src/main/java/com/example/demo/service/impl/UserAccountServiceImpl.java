package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
        return userRepo.save(user);
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return userRepo.findById(id);
    }

    // ✅ MUST RETURN Optional<UserAccount>
    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        Optional<UserAccount> userOpt = userRepo.findById(id);
        if (userOpt.isPresent()) {
            UserAccount user = userOpt.get();
            user.setStatus(status);
            return userRepo.save(user);
        }
        return null;
    }
}
