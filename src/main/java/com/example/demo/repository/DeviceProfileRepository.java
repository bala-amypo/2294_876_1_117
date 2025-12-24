// package com.example.demo.repository;

// import java.util.*;
// import com.example.demo.entity.*;

// public interface DeviceProfileRepository {
//     DeviceProfile save(DeviceProfile d);
//     Optional<DeviceProfile> findById(Long id);
//     Optional<DeviceProfile> findByDeviceId(String deviceId);
// }


package com.example.demo.repository;

import com.example.demo.entity.DeviceProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    DeviceProfile findByDeviceId(String deviceId);  // used in your service
}
