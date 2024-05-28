package com.lihtnegym.lihtne_gym.mapper;

import com.lihtnegym.lihtne_gym.dto.UserProfileDTO;
import com.lihtnegym.lihtne_gym.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfileDTO toUserProfileDTO(UserProfile userProfile);
    UserProfile toUserProfile(UserProfileDTO userProfileDTO);
}