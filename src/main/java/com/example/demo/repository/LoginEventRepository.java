package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {
    List<LoginEvent> findByUserId(Long userId);

    // If you want to filter by status, make sure the entity has "status" field (not loginStatus)
    List<LoginEvent> findByUserIdAndStatus(Long userId, String status);
}
