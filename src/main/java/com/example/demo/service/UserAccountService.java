package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.*;

public interface UserAccountService {
    UserAccount createUser(UserAccount u);
    UserAccount getUserById(Long id);
    UserAccount updateUserStatus(Long id, String status);
    List<UserAccount> getAllUsers();
}
