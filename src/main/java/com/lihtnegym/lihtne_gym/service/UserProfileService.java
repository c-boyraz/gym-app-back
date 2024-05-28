package com.lihtnegym.lihtne_gym.service;

import com.lihtnegym.lihtne_gym.dto.UserProfileDTO;

import java.util.List;

public interface UserProfileService {
    UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO);
    List<UserProfileDTO> getAllUserProfiles();
    UserProfileDTO getUserProfileById(Long id);
    void deleteUserProfile(Long id);
}
