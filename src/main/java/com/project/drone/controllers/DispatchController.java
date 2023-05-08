package com.project.drone.controllers;

import com.project.drone.model.Drone;
import com.project.drone.model.Medication;
import com.project.drone.service.DroneService;
import com.project.drone.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dispatch")
public class DispatchController {


    private final DroneService droneService;

    private final MedicationService medicationService;

     public DispatchController(DroneService droneService, MedicationService medicationService){
        this.droneService = droneService;
        this.medicationService = medicationService;
    }


    @PostMapping("/drone/{medicationId}")
    public ResponseEntity<List<Drone>> dispatchDrone(@PathVariable Integer medicationId) {

        List<Drone> availableDrones = new ArrayList<>();

        Medication medication = medicationService.findMedicationById(medicationId);

        if(medication!=null){
          availableDrones = droneService.findAvailableDroneForLoading(medication);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(availableDrones, HttpStatus.OK);
    }
}
