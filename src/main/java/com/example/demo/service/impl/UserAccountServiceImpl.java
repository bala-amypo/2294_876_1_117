package com.example.demo.service.impl;

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
        
    }

    @Override
    public void deleteUser(Long id) {
        
    }

    @Override
    public UserAccount findByUsername(String username) {

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
