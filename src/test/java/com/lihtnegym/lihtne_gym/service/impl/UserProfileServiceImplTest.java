package com.lihtnegym.lihtne_gym.service.impl;

import com.lihtnegym.lihtne_gym.dto.UserProfileDTO;
import com.lihtnegym.lihtne_gym.entity.UserProfile;
import com.lihtnegym.lihtne_gym.impl.UserProfileServiceImpl;
import com.lihtnegym.lihtne_gym.mapper.UserProfileMapper;
import com.lihtnegym.lihtne_gym.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserProfileServiceImplTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @Mock
    private UserProfileMapper userProfileMapper;

    @InjectMocks
    private UserProfileServiceImpl userProfileService;

    private UserProfile userProfile;
    private UserProfileDTO userProfileDTO;

    @BeforeEach
    public void setUp() {
        userProfile = new UserProfile();
        userProfile.setId(1L);
        userProfile.setName("John Doe");
        userProfile.setAge(30);
        userProfile.setHeight(180.0);
        userProfile.setWeight(75.0);
        userProfile.setHealthProblems("None");
        userProfile.setPhoneNumber("1234567890");
        userProfile.setWishes("Gain muscle");

        userProfileDTO = new UserProfileDTO();
        userProfileDTO.setName("John Doe");
        userProfileDTO.setAge(30);
        userProfileDTO.setHeight(180.0);
        userProfileDTO.setWeight(75.0);
        userProfileDTO.setHealthProblems("None");
        userProfileDTO.setPhoneNumber("1234567890");
        userProfileDTO.setWishes("Gain muscle");
    }

    @Test
    public void testCreateUserProfile() {
        when(userProfileMapper.toUserProfile(any(UserProfileDTO.class))).thenReturn(userProfile);
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(userProfile);
        when(userProfileMapper.toUserProfileDTO(any(UserProfile.class))).thenReturn(userProfileDTO);

        UserProfileDTO createdUserProfile = userProfileService.createUserProfile(userProfileDTO);

        assertNotNull(createdUserProfile);
        assertEquals("John Doe", createdUserProfile.getName());
        verify(userProfileRepository, times(1)).save(any(UserProfile.class));
    }

    @Test
    public void testGetAllUserProfiles() {
        List<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(userProfile);
        when(userProfileRepository.findAll()).thenReturn(userProfileList);
        when(userProfileMapper.toUserProfileDTO(any(UserProfile.class))).thenReturn(userProfileDTO);

        List<UserProfileDTO> userProfiles = userProfileService.getAllUserProfiles();

        assertNotNull(userProfiles);
        assertEquals(1, userProfiles.size());
        verify(userProfileRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserProfileById() {
        when(userProfileRepository.findById(anyLong())).thenReturn(Optional.of(userProfile));
        when(userProfileMapper.toUserProfileDTO(any(UserProfile.class))).thenReturn(userProfileDTO);

        UserProfileDTO foundUserProfile = userProfileService.getUserProfileById(1L);

        assertNotNull(foundUserProfile);
        assertEquals("John Doe", foundUserProfile.getName());
        verify(userProfileRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteUserProfile() {
        doNothing().when(userProfileRepository).deleteById(anyLong());

        userProfileService.deleteUserProfile(1L);

        verify(userProfileRepository, times(1)).deleteById(1L);
    }
}
