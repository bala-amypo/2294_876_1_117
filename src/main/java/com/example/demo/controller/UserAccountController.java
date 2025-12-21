package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id, @RequestParam String status) {
        return userService.updateUserStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.getUserById(id); // Verify exists
        userService.getAllUsers().removeIf(u -> u.getId().equals(id));
        return "User deleted successfully";
    }
}
