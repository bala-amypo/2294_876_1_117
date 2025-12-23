package com.example.demo.service;

import java.util.List;

public interface LoginEventService {

    List<String> getSuspiciousLogins(Long userId);
}
