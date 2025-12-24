package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface LoginEventRepository {
    LoginEvent save(LoginEvent e);
    List<LoginEvent> findByUserId(Long userId);
    List<LoginEvent> findByUserIdAndLoginStatus(Long userId, String status);
}
