package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile createProfile(DeviceProfile profile);

    DeviceProfile getProfileById(Long id);

    List<DeviceProfile> getAllProfiles();

    DeviceProfile updateProfile(Long id, DeviceProfile profile);

    void deleteProfile(Long id);
}
