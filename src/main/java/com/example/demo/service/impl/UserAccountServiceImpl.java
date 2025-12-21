=package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final List<UserAccount> dummyDB = new ArrayList<>();

    @Override
    public UserAccount createUser(UserAccount user) {
        dummyDB.add(user);
        return user;
    }

    @Override
    public UserAccount getUserById(Long id) {
        // Return dummy user for testing
        UserAccount user = new UserAccount();
        user.setId(id);
        user.setUsername("dummyUser");
        user.setEmail("dummy@example.com");
        user.setRole("USER");
        user.setStatus("ACTIVE");
        return user;
    }

    @Override
    public void updateUserStatus(Long id, String status) {
        // Dummy implementation
    }

    @Override
    public void deleteUser(Long id) {
        // Dummy implementation
    }

    @Override
    public UserAccount findByUsername(String username) {
        // Return dummy user for testing
        UserAccount user = new UserAccount();
        user.setId(1L);
        user.setUsername(username);
        user.setEmail("dummy@example.com");
        user.setRole("USER");
        user.setStatus("ACTIVE");
        return user;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return dummyDB;
    }
}
