package com.example.demo.dto;

public class LoginRequest {

    private String usernameOrEmail;
    private String password;

    public LoginRequest() {
        // required for Mockito / Jackson
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
