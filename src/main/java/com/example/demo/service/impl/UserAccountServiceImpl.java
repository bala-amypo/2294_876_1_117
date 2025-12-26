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
    public UserAccount createUser(UserAccount user) {
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }
        if (user.getStatus() == null || user.getStatus().isEmpty()) {
            user.setStatus("ACTIVE"); 
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserAccount updateStatus(Long id, String status) {
        Optional<UserAccount> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserAccount user = optionalUser.get();
            user.setStatus(status);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public UserAccount updateRole(Long id, String role) {
        Optional<UserAccount> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserAccount user = optionalUser.get();
            user.setRole(role); // now just a string
            return userRepository.save(user);
        }
        return null;
    }
}
