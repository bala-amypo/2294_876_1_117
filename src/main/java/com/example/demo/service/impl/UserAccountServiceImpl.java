package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepository;
    private final LoginEventRepository loginEventRepository;

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
    public UserAccount getUserById(Long id) {
        return userRepository.findById(id).orElse(null); // must return UserAccount, not Optional
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepository.findByUsername(username); // now matches interface
    }

    // Example: Login event logging
    public void logUserLoginEvent(UserAccount user, String ipAddress, String deviceId) {
        LoginEvent event = new LoginEvent();
        event.setUserId(user.getId());
        event.setIpAddress(ipAddress);
        event.setDeviceId(deviceId);
        event.setLoginStatus("SUCCESS");
        event.setLoginTime(LocalDateTime.now());
        loginEventRepository.save(event);
    }
}
