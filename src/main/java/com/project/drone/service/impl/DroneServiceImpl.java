package com.project.drone.service.impl;

import com.project.drone.model.Drone;
import com.project.drone.model.Medication;
import com.project.drone.repositories.DroneRepository;
import com.project.drone.service.DroneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository){
        this.droneRepository = droneRepository;
    }

    @Override
    public Drone addNewDrone(Drone drone) {
        return null;
    }

    @Override
    public List<Drone> findAvailableDroneForLoading(Medication medication) {

        List<Drone> droneList = droneRepository.findAllAvailableDrones();
        return droneList;
    }
}
