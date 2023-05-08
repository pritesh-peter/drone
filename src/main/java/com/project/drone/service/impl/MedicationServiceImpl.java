package com.project.drone.service.impl;

import com.project.drone.model.Medication;
import com.project.drone.repositories.MedicationRepository;
import com.project.drone.service.MedicationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicationServiceImpl implements MedicationService {


    private final MedicationRepository medicationRepository;

    public MedicationServiceImpl(MedicationRepository medicationRepository){
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Medication findMedicationById(int medicationId) {

        return medicationRepository.findById(medicationId).orElse(null);
    }
}
