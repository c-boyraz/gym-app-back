package com.lihtnegym.lihtne_gym.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "workout_plans")
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bodyPart;
    private String outcome;
}
