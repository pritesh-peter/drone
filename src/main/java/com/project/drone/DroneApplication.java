package com.project.drone;


import com.project.drone.model.*;
import com.project.drone.repositories.DroneRepository;
import com.project.drone.repositories.DroneToMedicationRepository;
import com.project.drone.repositories.MedicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DroneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(DroneRepository droneRepository, MedicationRepository medicationRepository, DroneToMedicationRepository droneToMedicationRepository){
		return args -> {
			//Inserting dummy datas for drone
			List<Drone> droneList = new ArrayList<>();
			Drone drone = new Drone();
			drone.setSerialNumber("DRN572462506325");
			drone.setModel("lightweight");
			drone.setWeightLimit(400);
			drone.setBatteryCapacity(80);
			drone.setDroneState(DroneState.LOADING);
			droneList.add(drone);

			Drone drone1 = new Drone();
			drone1.setSerialNumber("DRN572462506326");
			drone1.setModel("lightweight");
			drone1.setWeightLimit(400);
			drone1.setBatteryCapacity(45);
			drone1.setDroneState(DroneState.IDLE);
			droneList.add(drone1);

			Drone drone2 = new Drone();
			drone2.setSerialNumber("DRN572462506327");
			drone2.setModel("lightweight");
			drone2.setWeightLimit(400);
			drone2.setBatteryCapacity(50);
			drone2.setDroneState(DroneState.IDLE);
			droneList.add(drone2);

			Drone drone3 = new Drone();
			drone3.setSerialNumber("DRN572462506328");
			drone3.setModel("lightweight");
			drone3.setWeightLimit(400);
			drone3.setBatteryCapacity(24);
			drone3.setDroneState(DroneState.LOADING);
			droneList.add(drone3);

			Drone drone4 = new Drone();
			drone4.setSerialNumber("DRN572462506329");
			drone4.setModel("lightweight");
			drone4.setWeightLimit(400);
			drone4.setBatteryCapacity(80);
			drone4.setDroneState(DroneState.IDLE);
			droneList.add(drone4);

			Drone drone5 = new Drone();
			drone5.setSerialNumber("DRN572462506330");
			drone5.setModel("lightweight");
			drone5.setWeightLimit(400);
			drone5.setBatteryCapacity(45);
			drone5.setDroneState(DroneState.LOADED);
			droneList.add(drone5);

			Drone drone6 = new Drone();
			drone6.setSerialNumber("DRN572462506331");
			drone6.setModel("lightweight");
			drone6.setWeightLimit(500);
			drone6.setBatteryCapacity(50);
			drone6.setDroneState(DroneState.IDLE);
			droneList.add(drone6);

			Drone drone7 = new Drone();
			drone7.setSerialNumber("DRN572462506332");
			drone7.setModel("lightweight");
			drone7.setWeightLimit(500);
			drone7.setBatteryCapacity(30);
			drone7.setDroneState(DroneState.DELIVERED);
			droneList.add(drone7);
			droneRepository.saveAll(droneList);

			Drone drone8 = new Drone();
			drone8.setSerialNumber("DRN572462506333");
			drone8.setModel("lightweight");
			drone8.setWeightLimit(500);
			drone8.setBatteryCapacity(50);
			drone8.setDroneState(DroneState.DELIVERING);
			droneList.add(drone8);

			Drone drone9 = new Drone();
			drone9.setSerialNumber("DRN572462506334");
			drone9.setModel("lightweight");
			drone9.setWeightLimit(500);
			drone9.setBatteryCapacity(24);
			drone9.setDroneState(DroneState.DELIVERING);
			droneList.add(drone9);
			droneRepository.saveAll(droneList);

			//Inserting dummy datas for medication
			Medication m2 = new Medication();
			m2.setName("G125JX");
			m2.setWeight(100);
			m2.setMedicationCode("KSLKKK12");
			m2.setMedicationImage("KSLKKK12.jpeg");
			medicationRepository.save(m2);

			Medication m3 = new Medication();
			m3.setName("G122JX");
			m3.setWeight(100);
			m3.setMedicationCode("KSLKKK12");
			m3.setMedicationImage("KSLKKK12.jpeg");
			medicationRepository.save(m3);

			Medication m4 = new Medication();
			m4.setName("G124JX");
			m4.setWeight(100);
			m4.setMedicationCode("KSLKKK12");
			m4.setMedicationImage("KSLKKK12.jpeg");
			medicationRepository.save(m4);

			Medication m5 = new Medication();
			m5.setName("G127JX");
			m5.setWeight(100);
			m5.setMedicationCode("KSLKKK12");
			m5.setMedicationImage("KSLKKK12.jpeg");
			medicationRepository.save(m5);


			//Inserting dummy datas for DroneToMedication

			DroneToMedication dm1 = new DroneToMedication();
			dm1.setDrone(drone3);
			dm1.setMedication(m5);
			dm1.setMedicationState(MedicationState.LOADING);
			droneToMedicationRepository.save(dm1);

			DroneToMedication dm2 = new DroneToMedication();
			dm2.setDrone(drone3);
			dm2.setMedication(m5);
			dm2.setMedicationState(MedicationState.LOADING);
			droneToMedicationRepository.save(dm2);

			DroneToMedication dm3 = new DroneToMedication();
			dm3.setDrone(drone);
			dm3.setMedication(m5);
			dm3.setMedicationState(MedicationState.LOADING);
			droneToMedicationRepository.save(dm3);

			DroneToMedication dm4 = new DroneToMedication();
			dm4.setDrone(drone3);
			dm4.setMedication(m5);
			dm4.setMedicationState(MedicationState.LOADING);
			droneToMedicationRepository.save(dm4);

			DroneToMedication dm5 = new DroneToMedication();
			dm5.setDrone(drone3);
			dm5.setMedication(m2);
			dm5.setMedicationState(MedicationState.LOADING);
			droneToMedicationRepository.save(dm5);
		};
	}
}

