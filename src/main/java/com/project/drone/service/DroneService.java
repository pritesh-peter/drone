package com.project.drone.service;

import com.project.drone.model.Drone;
import com.project.drone.model.Medication;

import java.util.List;

public interface DroneService {

    Drone addNewDrone(Drone drone);

    List<Drone> findAvailableDroneForLoading(Medication medication);
}
