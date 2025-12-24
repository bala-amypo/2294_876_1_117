package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepository;
    private final LoginEventRepository loginEventRepository; // Injected

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userRepository,
                                  LoginEventRepository loginEventRepository) {
        this.userRepository = userRepository;
        this.loginEventRepository = loginEventRepository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setCreatedAt(LocalDateTime.now());
        if (user.getRole() == null) {
            user.setRole("USER"); // default role
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        Optional<UserAccount> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            UserAccount user = optUser.get();
            user.setStatus(status);
            return userRepository.save(user);
        }
        return null;
    }

    // Example of referencing LoginEvent if needed
    public void logUserLoginEvent(UserAccount user, String ipAddress, String deviceId) {
        // Create LoginEvent and save
        com.example.demo.entity.LoginEvent event = new com.example.demo.entity.LoginEvent();
        event.setUserId(user.getId());
        event.setIpAddress(ipAddress);
        event.setDeviceId(deviceId);
        event.setLoginStatus("SUCCESS");
        event.setLoginTime(LocalDateTime.now());
        loginEventRepository.save(event);
    }
}
