package com.project.drone;


import com.project.drone.model.Drone;
import com.project.drone.model.DroneState;
import com.project.drone.model.Medication;
import com.project.drone.repositories.DroneRepository;
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
	CommandLineRunner commandLineRunner(DroneRepository droneRepository, MedicationRepository medicationRepository){
		return args -> {
			List<Drone> droneList = new ArrayList<>();
			Drone drone = new Drone();
			drone.setSerialNumber("DRN572462506325");
			drone.setModel("lightweight");
			drone.setLoadWeight(400);
			drone.setBatteryCapacity(80);
			drone.setDroneState(DroneState.IDLE);
			droneList.add(drone);

			Drone drone1 = new Drone();
			drone1.setSerialNumber("DRN572462506326");
			drone1.setModel("lightweight");
			drone1.setLoadWeight(400);
			drone1.setBatteryCapacity(45);
			drone1.setDroneState(DroneState.LOADED);
			droneList.add(drone1);

			Drone drone2 = new Drone();
			drone2.setSerialNumber("DRN572462506327");
			drone2.setModel("lightweight");
			drone2.setLoadWeight(400);
			drone2.setBatteryCapacity(50);
			drone2.setDroneState(DroneState.LOADING);
			droneList.add(drone2);

			Drone drone3 = new Drone();
			drone3.setSerialNumber("DRN572462506328");
			drone3.setModel("lightweight");
			drone3.setLoadWeight(400);
			drone3.setBatteryCapacity(24);
			drone3.setDroneState(DroneState.LOADING);
			droneList.add(drone3);
			droneRepository.saveAll(droneList);

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

		};
	}
}

