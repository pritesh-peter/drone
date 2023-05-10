package com.project.drone.service.impl;

import com.project.drone.exceptions.ResourceNotFoundException;
import com.project.drone.model.DroneToMedication;
import com.project.drone.model.Medication;
import com.project.drone.repositories.DroneToMedicationRepository;
import com.project.drone.repositories.MedicationRepository;
import com.project.drone.service.MedicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService {


    private final MedicationRepository medicationRepository;

    private final DroneToMedicationRepository droneToMedicationRepository;
    public MedicationServiceImpl(MedicationRepository medicationRepository,DroneToMedicationRepository droneToMedicationRepository){
        this.medicationRepository = medicationRepository;
        this.droneToMedicationRepository = droneToMedicationRepository;
    }

    @Override
    public Medication findMedicationById(int medicationId) {

        return medicationRepository.findById(medicationId)
                .orElseThrow(()->new ResourceNotFoundException("Medication","Id",medicationId));
    }

    @Override
    public List<Medication> findLoadedMedicationsByDrone(Integer droneId) {
        List<DroneToMedication> droneToMedicationList = droneToMedicationRepository.findAllByDroneId(droneId);

        List<Medication> medicationList = droneToMedicationList.stream()
                .map(dm->dm.getMedication())
                .collect(Collectors.toList());

        return medicationList;
    }
}
