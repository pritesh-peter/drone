package com.project.drone.controllers;

import com.project.drone.model.Drone;
import com.project.drone.model.Medication;
import com.project.drone.repositories.DroneToMedicationRepository;
import com.project.drone.service.DroneService;
import com.project.drone.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drone")
public class DispatchController {


    private final DroneService droneService;

    private final MedicationService medicationService;

    private final DroneToMedicationRepository droneToMedicationRepository;

     public DispatchController(DroneService droneService, MedicationService medicationService,DroneToMedicationRepository droneToMedicationRepository){
        this.droneService = droneService;
        this.medicationService = medicationService;
        this.droneToMedicationRepository = droneToMedicationRepository;
    }


    @PostMapping("/dispatch/{medicationId}")
    public ResponseEntity<List<Drone>> dispatchDrone(@PathVariable Integer medicationId) {

        Medication medication = medicationService.findMedicationById(medicationId);

        List<Drone>    availableDrones = droneService.findAvailableDroneForLoading(medication);

        return new ResponseEntity<>(availableDrones, HttpStatus.OK);
    }
    @GetMapping("/check-medications/{droneId}")
    public ResponseEntity<List<Medication>> checkLoadedMedication(@PathVariable Integer droneId){

//         Drone drone = droneService.findDroneById(droneId);

         List<Medication> medicationList = medicationService.findLoadedMedicationsByDrone(droneId);
         return new ResponseEntity<>(medicationList,HttpStatus.OK);
    }
}
