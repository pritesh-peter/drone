package com.project.drone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DroneToMedication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    @ManyToOne
    @JoinColumn(name = "drone_id")
    Drone drone;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    Medication medication;

    MedicationState medicationState;
}
