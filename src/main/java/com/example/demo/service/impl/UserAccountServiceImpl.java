package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepository;

    public UserAccountServiceImpl(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserAccount> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        Optional<UserAccount> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserAccount user = optionalUser.get();
            user.setStatus(status); // Make sure UserAccount entity has a 'status' field
            return userRepository.save(user);
        }
        return null; // or throw exception if preferred
    }
}
