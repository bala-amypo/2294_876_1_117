package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile createProfile(DeviceProfile profile) {
        return repo.save(profile);
    }

    @Override
    public DeviceProfile getProfileById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DeviceProfile not found"));
    }

    @Override
    public List<DeviceProfile> getAllProfiles() {
        return repo.findAll();
    }

    @Override
    public DeviceProfile updateProfile(Long id, DeviceProfile profile) {
        DeviceProfile existing = getProfileById(id);
        existing.setName(profile.getName());
        existing.setDescription(profile.getDescription());
        return repo.save(existing);
    }

    @Override
    public void deleteProfile(Long id) {
        DeviceProfile existing = getProfileById(id);
        repo.delete(existing);
    }
}
