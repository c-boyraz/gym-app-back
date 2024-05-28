package com.lihtnegym.lihtne_gym.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private double height;
    private double weight;
    private String healthProblems;
    private String phoneNumber;
    private String wishes;
}
