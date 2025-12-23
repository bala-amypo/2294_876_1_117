package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    // METHOD NAME MUST BE create()
    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return service.createUser(user);
    }
}
