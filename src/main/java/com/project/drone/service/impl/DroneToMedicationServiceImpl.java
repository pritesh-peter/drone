package com.project.drone.service.impl;

import com.project.drone.model.DroneToMedication;
import com.project.drone.model.Medication;
import com.project.drone.model.MedicationState;
import com.project.drone.payloads.AvailableDrone;
import com.project.drone.repositories.DroneToMedicationRepository;
import com.project.drone.service.DroneService;
import com.project.drone.service.DroneToMedicationService;
import org.springframework.stereotype.Service;

@Service
public class DroneToMedicationServiceImpl implements DroneToMedicationService {

    private final DroneToMedicationRepository droneToMedicationRepository;
    private final DroneService droneService;

    public DroneToMedicationServiceImpl(DroneToMedicationRepository droneToMedicationRepository, DroneService droneService){
        this.droneToMedicationRepository = droneToMedicationRepository;
        this.droneService = droneService;
    }
    @Override
    public DroneToMedication addDroneToMedication(AvailableDrone bestAvailableDroneForLoad, Medication medication) {

        DroneToMedication droneToMedication = new DroneToMedication();
        droneToMedication.setMedication(medication);
        droneToMedication.setMedicationState(MedicationState.WAITING);
        droneToMedication.setDrone(droneService.findDroneById(bestAvailableDroneForLoad.getId()));
        droneToMedicationRepository.save(droneToMedication);

        return droneToMedication;
    }
}
