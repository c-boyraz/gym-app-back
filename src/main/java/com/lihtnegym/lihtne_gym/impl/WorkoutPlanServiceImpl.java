package com.lihtnegym.lihtne_gym.service.impl;

import com.lihtnegym.lihtne_gym.entity.WorkoutPlan;
import com.lihtnegym.lihtne_gym.repository.WorkoutPlanRepository;
import com.lihtnegym.lihtne_gym.service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutPlanServiceImpl implements WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Override
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    @Override
    public WorkoutPlan getWorkoutPlanById(Long id) {
        return workoutPlanRepository.findById(id).orElseThrow(() -> new RuntimeException("Workout Plan not found"));
    }
}
