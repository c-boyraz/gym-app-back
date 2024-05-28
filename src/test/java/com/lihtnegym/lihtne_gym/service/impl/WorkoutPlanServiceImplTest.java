package com.lihtnegym.lihtne_gym.service.impl;

import com.lihtnegym.lihtne_gym.entity.WorkoutPlan;
import com.lihtnegym.lihtne_gym.repository.WorkoutPlanRepository;
import com.lihtnegym.lihtne_gym.service.WorkoutPlanService;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WorkoutPlanServiceImplTest {

    @Mock
    private WorkoutPlanRepository workoutPlanRepository;

    @InjectMocks
    private com.lihtnegym.lihtne_gym.service.impl.WorkoutPlanServiceImpl workoutPlanService;

    private WorkoutPlan workoutPlan;

    @BeforeEach
    public void setUp() {
        workoutPlan = new WorkoutPlan();
        workoutPlan.setId(1L);
        workoutPlan.setBodyPart("Chest");
        workoutPlan.setOutcome("Build muscle");
    }

    @Test
    public void testGetAllWorkoutPlans() {
        List<WorkoutPlan> workoutPlanList = new ArrayList<>();
        workoutPlanList.add(workoutPlan);
        when(workoutPlanRepository.findAll()).thenReturn(workoutPlanList);

        List<WorkoutPlan> workoutPlans = workoutPlanService.getAllWorkoutPlans();

        assertNotNull(workoutPlans);
        assertEquals(1, workoutPlans.size());
        verify(workoutPlanRepository, times(1)).findAll();
    }

    @Test
    public void testGetWorkoutPlanById() {
        when(workoutPlanRepository.findById(anyLong())).thenReturn(Optional.of(workoutPlan));

        WorkoutPlan foundWorkoutPlan = workoutPlanService.getWorkoutPlanById(1L);

        assertNotNull(foundWorkoutPlan);
        assertEquals("Chest", foundWorkoutPlan.getBodyPart());
        verify(workoutPlanRepository, times(1)).findById(1L);
    }
}
