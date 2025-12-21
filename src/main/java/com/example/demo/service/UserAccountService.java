package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

ppublic interface UserAccountService {
    UserAccount createUser(UserAccount user);
    void updateUserStatus(long id, String status);
}
