package com.project.drone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneToMedication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    @ManyToOne
    @JoinColumn(name = "drone_serial_number")
    @JsonIgnore
    Drone drone;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    @JsonIgnore
    Medication medication;

    DroneState droneState;
}
