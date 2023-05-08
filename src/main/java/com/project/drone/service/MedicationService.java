package com.project.drone.service;

import com.project.drone.model.Medication;

import java.util.List;

public interface MedicationService {


    Medication findMedicationById(int medicationId);

    List<Medication> findLoadedMedicationsByDrone(Integer droneId);
}
