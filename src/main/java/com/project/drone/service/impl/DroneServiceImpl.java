package com.project.drone.service.impl;

import com.project.drone.exceptions.ResourceNotFoundException;
import com.project.drone.model.Drone;
import com.project.drone.model.DroneState;
import com.project.drone.model.DroneToMedication;
import com.project.drone.model.Medication;
import com.project.drone.payloads.AvailableDrone;
import com.project.drone.repositories.DroneRepository;
import com.project.drone.repositories.DroneToMedicationRepository;
import com.project.drone.service.DroneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    private final DroneToMedicationRepository droneToMedicationRepository;

    public DroneServiceImpl(DroneRepository droneRepository, DroneToMedicationRepository droneToMedicationRepository){
        this.droneRepository = droneRepository;
        this.droneToMedicationRepository = droneToMedicationRepository;
    }

    @Override
    public Drone addNewDrone(Drone drone) {
        return null;
    }

    @Override
    public List<AvailableDrone> findAvailableDroneForLoading(Integer medicationWeight) {


        return droneToMedicationRepository.getAvailableDroneForLoading(medicationWeight);
    }

    @Override
    public Drone findDroneById(Integer droneId) {

        return droneRepository.findById(droneId)
                .orElseThrow(()-> new ResourceNotFoundException("Drone","id",droneId));
    }
}
