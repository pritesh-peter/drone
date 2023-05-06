package com.project.drone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Drone {

    @Id
    String serialNumber;

    String model;

    Float loadWeight;

    Float batteryCapacity;

    DroneState droneState;
}
