package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {

    // Corrected method
    List<LoginEvent> findByUserIdAndStatus(Long userId, String status);

    // If you need by status only
    List<LoginEvent> findByStatus(String status);
}
