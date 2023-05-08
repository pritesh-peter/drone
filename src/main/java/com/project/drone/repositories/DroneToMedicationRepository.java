package com.project.drone.repositories;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneToMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneToMedicationRepository extends JpaRepository<DroneToMedication,String> {


    @Query(value="SELECT * FROM drone_to_medication ",nativeQuery = true)
    List<DroneToMedication> findByDroneSerialNumber();

//
//    @Query(value="SELECT * FROM DRONE d where d.battery_capacity>25 and (d.drone_state =0 or d.drone_state =1) and weigt_limit>=?1",nativeQuery = true)
//    List<Drone> findAllAvailableDrones(int weight);
}
