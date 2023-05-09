package com.project.drone.service;

import com.project.drone.model.DroneToMedication;
import com.project.drone.model.Medication;
import com.project.drone.payloads.AvailableDrone;

public interface DroneToMedicationService {
    DroneToMedication addDroneToMedication(AvailableDrone bestAvailableDroneForLoad, Medication medication);
}
