package com.project.drone.service;

import com.project.drone.model.Drone;
import com.project.drone.payloads.AvailableDrone;

import java.util.List;

public interface DroneService {


    List<AvailableDrone> findAvailableDroneForLoading(Double medicationWeight);

    Drone findDroneById(Integer droneId);
}
