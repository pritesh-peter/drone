package com.project.drone.repositories;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneToMedication;
import com.project.drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneToMedicationRepository extends JpaRepository<DroneToMedication,String> {


    @Query(value="SELECT * FROM drone_to_medication ",nativeQuery = true)
    List<DroneToMedication> findByDroneSerialNumber();

    List<DroneToMedication> findAllByDroneId(Integer droneId);


}
