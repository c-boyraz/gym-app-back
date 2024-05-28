package com.lihtnegym.lihtne_gym.impl;

import com.lihtnegym.lihtne_gym.dto.UserProfileDTO;
import com.lihtnegym.lihtne_gym.entity.UserProfile;
import com.lihtnegym.lihtne_gym.mapper.UserProfileMapper;
import com.lihtnegym.lihtne_gym.repository.UserProfileRepository;
import com.lihtnegym.lihtne_gym.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = userProfileMapper.toUserProfile(userProfileDTO);
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileDTO(savedUserProfile);
    }

    @Override
    public List<UserProfileDTO> getAllUserProfiles() {
        return userProfileRepository.findAll().stream()
                .map(userProfileMapper::toUserProfileDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserProfileDTO getUserProfileById(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userProfileMapper.toUserProfileDTO(userProfile);
    }

    @Override
    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}
