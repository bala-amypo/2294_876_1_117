package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {

    // Now this works because LoginEvent has loginStatus field
    List<LoginEvent> findByUserIdAndLoginStatus(Long userId, String loginStatus);
    
    List<LoginEvent> findByUserId(Long userId);
}
