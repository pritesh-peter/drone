package com.project.drone.controllers;

import com.project.drone.model.*;
import com.project.drone.payloads.AvailableDrone;
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


    @GetMapping("/available-to-load/{medicationId}")
    public ResponseEntity<List<AvailableDrone>> dronesAvailableToLoad(@PathVariable Integer medicationId) {

        Medication medication = medicationService.findMedicationById(medicationId);

        List<AvailableDrone>  availableDrones = droneService.findAvailableDroneForLoading(medication.getWeight());

        return new ResponseEntity<>(availableDrones, HttpStatus.OK);
    }
    @PostMapping("/dispatch-drone/")
    public ResponseEntity<DroneToMedication> dispatchDrone(@RequestBody Integer medicationId) {

        Medication medication = medicationService.findMedicationById(medicationId);

        List<AvailableDrone>  availableDrones = droneService.findAvailableDroneForLoading(medication.getWeight());

        AvailableDrone bestAvailableDroneForLoad = availableDrones.get(0);

        DroneToMedication droneToMedication = new DroneToMedication();
        droneToMedication.setMedication(medication);
        droneToMedication.setMedicationState(MedicationState.WAITING);
        droneToMedication.setDrone(droneService.findDroneById(bestAvailableDroneForLoad.getId()));
        droneToMedicationRepository.save(droneToMedication);

        return new ResponseEntity<>(droneToMedication, HttpStatus.OK);
    }

    @GetMapping("/check-medications/{droneId}")
    public ResponseEntity<List<Medication>> checkLoadedMedication(@PathVariable Integer droneId){

         List<Medication> medicationList = medicationService.findLoadedMedicationsByDrone(droneId);
         return new ResponseEntity<>(medicationList,HttpStatus.OK);
    }

    @PostMapping("/event-log")
    public ResponseEntity<String> createEventLog(@RequestBody Drone drone){

         //update drone batery level too

    return null;
    }
}
