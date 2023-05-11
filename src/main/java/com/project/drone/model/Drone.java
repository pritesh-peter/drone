package com.project.drone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
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

    @Size(max = 100, message = "Maximum 100 characters allowed")
    private String serialNumber;

    private String model;

    @Max(value = 500, message = "Maximum value allowed is 500 grams")
    private double weightLimit;

    @DecimalMin(value = "0.00", message = "Percentage must be greater than or equal to 0.00")
    @DecimalMax(value = "100.00", message = "Percentage must be less than or equal to 100.00")
    private int batteryCapacity;

    private DroneState droneState;

}
