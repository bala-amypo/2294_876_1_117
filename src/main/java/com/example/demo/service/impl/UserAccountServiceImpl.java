package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
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
        return userRepo.save(user);
    }

    @Override
    public UserAccount authenticate(String username, String password) {
        return userRepo.findByUsername(username);
    }

@Override
public UserAccount getUserById(Long id) {
    return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
}
    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

@Override
public UserAccount updateStatus(Long id, String status) {
    UserAccount user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    user.setStatus(status);
    return repo.save(user);
}


    @Override
public String login(String username, String password) {
    UserAccount user = repo.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }
    return jwtUtil.generateToken(username);
}




@Override
public UserAccount updateUserStatus(Long id, String status) {
    UserAccount user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    user.setStatus(status);
    return repo.save(user);
}

}
