package com.project.drone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {

    @Id
    String serialNumber;

    String model;

    int loadWeight;

    int batteryCapacity;

    DroneState droneState;

}
