package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.*;

// public interface LoginEventService {
//     LoginEvent recordLogin(LoginEvent e);
//     List<LoginEvent> getEventsByUser(Long userId);
//     List<LoginEvent> getSuspiciousLogins(Long userId);
// }

public interface LoginEventService {
    List<LoginEvent> getSuspiciousEvents();
}
