package com.project.drone.service.impl;

import com.project.drone.exceptions.ResourceNotFoundException;
import com.project.drone.model.Drone;
import com.project.drone.payloads.AvailableDrone;
import com.project.drone.repositories.DroneRepository;
import com.project.drone.service.DroneService;
import com.project.drone.service.DroneToMedicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    private final DroneToMedicationService droneToMedicationService;

    public DroneServiceImpl(DroneRepository droneRepository,DroneToMedicationService droneToMedicationService){
        this.droneRepository = droneRepository;
        this.droneToMedicationService = droneToMedicationService;
    }

    @Override
    public List<AvailableDrone> findAvailableDroneForLoading(Double medicationWeight) {
        return  droneToMedicationService.getAvailableDronesForLoading(medicationWeight);
    }

    @Override
    public Drone findDroneById(Integer droneId) {
        return droneRepository.findById(droneId)
                .orElseThrow(()-> new ResourceNotFoundException("Drone","id",droneId));
    }
}
