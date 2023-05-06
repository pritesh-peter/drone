package com.project.drone;


import com.project.drone.model.Drone;
import com.project.drone.model.DroneState;
import com.project.drone.model.Medication;
import com.project.drone.repositories.DroneRepository;
import com.project.drone.service.impl.DroneServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DroneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(DroneRepository droneRepository){
		return args -> {
			Drone drone = new Drone();
			drone.setSerialNumber("DRN572462506325");
			drone.setModel("lightweight");
			drone.setLoadWeight(400);
			drone.setBatteryCapacity(45);
			drone.setDroneState(DroneState.valueOf("IDLE"));
			droneRepository.save(drone);

			Drone drone1 = new Drone();
			drone1.setSerialNumber("DRN572462506326");
			drone1.setModel("lightweight");
			drone1.setLoadWeight(400);
			drone1.setBatteryCapacity(45);
			drone1.setDroneState(DroneState.valueOf("IDLE"));
			droneRepository.save(drone1);

			Drone drone2 = new Drone();
			drone2.setSerialNumber("DRN572462506327");
			drone2.setModel("lightweight");
			drone2.setLoadWeight(400);
			drone2.setBatteryCapacity(45);
			drone2.setDroneState(DroneState.valueOf("IDLE"));
			droneRepository.save(drone2);

			Drone drone3 = new Drone();
			drone3.setSerialNumber("DRN572462506328");
			drone3.setModel("lightweight");
			drone3.setLoadWeight(400);
			drone3.setBatteryCapacity(45);
			drone3.setDroneState(DroneState.valueOf("IDLE"));
			droneRepository.save(drone3);

			Medication m1 = new Medication();
			m1.setName("G125JX");
			m1.setWeight(100);
			m1.setMedicationCode("KSLKKK12");
			m1.setMedicationImage("KSLKKK12.jpeg");

		};
	}
}

