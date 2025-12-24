// package com.example.demo.service;

// import java.util.*;
// import com.example.demo.entity.*;

// public interface LoginEventService {
//     LoginEvent recordLogin(LoginEvent e);
//     List<LoginEvent> getEventsByUser(Long userId);
//     List<LoginEvent> getSuspiciousLogins(Long userId);
// }

package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {
    LoginEvent recordLogin(LoginEvent loginEvent);
    List<LoginEvent> getEventsByUser(Long userId);
    List<LoginEvent> getSuspiciousLogins(Long userId);
}

