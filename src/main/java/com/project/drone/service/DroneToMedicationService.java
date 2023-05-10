package com.project.drone.service;

import com.project.drone.model.DroneToMedication;
import com.project.drone.model.Medication;
import com.project.drone.payloads.AvailableDrone;

import java.util.List;

public interface DroneToMedicationService {
    DroneToMedication addDroneToMedication(AvailableDrone bestAvailableDroneForLoad, Medication medication);

    List<AvailableDrone> getAvailableDronesForLoading(Double medicationWeight);
}
