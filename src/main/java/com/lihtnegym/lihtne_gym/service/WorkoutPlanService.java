package com.lihtnegym.lihtne_gym.service;

import com.lihtnegym.lihtne_gym.entity.WorkoutPlan;

import java.util.List;

public interface WorkoutPlanService {
    List<WorkoutPlan> getAllWorkoutPlans();
    WorkoutPlan getWorkoutPlanById(Long id);
}
