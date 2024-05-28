package com.lihtnegym.lihtne_gym.dto;

import lombok.Data;

@Data
public class UserProfileDTO {
    private String name;
    private int age;
    private double height;
    private double weight;
    private String healthProblems;
    private String phoneNumber;
    private String wishes;
}
