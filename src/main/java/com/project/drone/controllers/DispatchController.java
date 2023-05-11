package com.project.drone.controllers;

import com.project.drone.model.*;
import com.project.drone.payloads.AvailableDrone;
import com.project.drone.service.DroneService;
import com.project.drone.service.DroneToMedicationService;
import com.project.drone.service.EventLogService;
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

    private final DroneToMedicationService droneToMedicationService;

    private final EventLogService eventLogService;

     public DispatchController(DroneService droneService,MedicationService medicationService,DroneToMedicationService droneToMedicationService, EventLogService eventLogService){
        this.droneService = droneService;
        this.medicationService = medicationService;
        this.droneToMedicationService = droneToMedicationService;
        this.eventLogService = eventLogService;
    }


    @GetMapping("/available-to-load/{medicationId}")
    public ResponseEntity<List<AvailableDrone>> dronesAvailableToLoad(@PathVariable Integer medicationId) {

        Medication medication = medicationService.findMedicationById(medicationId);

        List<AvailableDrone>  availableDrones = droneService.findAvailableDroneForLoading(medication.getWeight());

        return new ResponseEntity<>(availableDrones, HttpStatus.OK);
    }
    @PostMapping("/dispatch-drone/")
    public ResponseEntity<DroneToMedication> dispatchDrone(@RequestBody Medication medication) {

        Medication loadingMecation = medicationService.findMedicationById(medication.getId());

        List<AvailableDrone>  availableDrones = droneService.findAvailableDroneForLoading(loadingMecation.getWeight());
        AvailableDrone bestAvailableDroneForLoad = availableDrones.get(0);

        DroneToMedication dispatchedDrone = droneToMedicationService.addDroneToMedication(bestAvailableDroneForLoad,loadingMecation);

        return new ResponseEntity<>(dispatchedDrone, HttpStatus.OK);
    }

    @GetMapping("/check-medications/{droneId}")
    public ResponseEntity<List<Medication>> checkLoadedMedication(@PathVariable Integer droneId){

         List<Medication> medicationList = medicationService.findLoadedMedicationsByDrone(droneId);
         return new ResponseEntity<>(medicationList,HttpStatus.OK);
    }

    @PostMapping("/event-log")
    public ResponseEntity<String> createEventLog(@RequestBody Drone drone){

         boolean createDroneBatteryStatusLog = eventLogService.createDroneBatteryStatusLog(drone);

         if(createDroneBatteryStatusLog){
             return new ResponseEntity<>("Success",HttpStatus.CREATED);
         }else{
             return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
         }
    }

    @GetMapping("/status/{droneId}")
    public ResponseEntity<Drone> getDroneStatus(@PathVariable int droneId){
         Drone drone = droneService.findDroneById(droneId);

         return new ResponseEntity<>(drone,HttpStatus.OK);
    }
}
