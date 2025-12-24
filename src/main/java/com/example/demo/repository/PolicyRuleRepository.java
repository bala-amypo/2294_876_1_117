// package com.example.demo.repository;

// import java.util.*;
// import com.example.demo.entity.*;

// public interface PolicyRuleRepository {
//     PolicyRule save(PolicyRule r);
//     List<PolicyRule> findByActiveTrue();
//     List<PolicyRule> findAll();
// }

package com.example.demo.repository;

import com.example.demo.entity.PolicyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {
}
