package com.project.drone.service;

import com.project.drone.model.Drone;
import com.project.drone.model.Medication;
import com.project.drone.payloads.AvailableDrone;

import java.util.List;

public interface DroneService {

    Drone addNewDrone(Drone drone);

    List<AvailableDrone> findAvailableDroneForLoading(Integer medicationWeight);

    Drone findDroneById(Integer droneId);
}
