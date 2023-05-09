package com.project.drone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String serialNumber;

    private String model;

    private double weightLimit;

    private int batteryCapacity;

    private DroneState droneState;

}
