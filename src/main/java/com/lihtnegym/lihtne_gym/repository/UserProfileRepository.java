package com.lihtnegym.lihtne_gym.repository;

import com.lihtnegym.lihtne_gym.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
