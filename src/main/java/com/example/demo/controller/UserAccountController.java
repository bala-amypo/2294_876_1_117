package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    public ResponseEntity<UserAccount> create(UserAccount u) {
        return ResponseEntity.ok(service.createUser(u));
    }
}
