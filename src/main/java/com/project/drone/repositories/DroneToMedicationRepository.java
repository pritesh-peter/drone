package com.project.drone.repositories;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneToMedication;
import com.project.drone.model.Medication;
import com.project.drone.payloads.AvailableDrone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneToMedicationRepository extends JpaRepository<DroneToMedication,String> {


    @Query(value="SELECT * FROM drone_to_medication ",nativeQuery = true)
    List<DroneToMedication> findByDroneSerialNumber();

    List<DroneToMedication> findAllByDroneId(Integer droneId);

    @Query(value="SELECT dr.id, SUM(m.weight) as loadedweight, (dr.weigt_limit-SUM(m.weight))  as availableWeightLimit  FROM DRONE_TO_MEDICATION d\n" +
            "inner join medication m on d.medication_id=m.id\n" +
            "inner join drone dr on d.drone_id=dr.id\n" +
            "where d.medication_state in ('0','1') and dr.battery_capacity>25\n" +
            "group by d.drone_id\n" +
            "having availableweightlimit>=?1\n" +
            "union \n" +
            "SELECT dr.id, 0 as loadedweight, dr.weigt_limit as availableWeightLimit  FROM DRONE_TO_MEDICATION d\n" +
            "right join drone dr on d.drone_id=dr.id\n" +
            "where dr.drone_state='0' and dr.battery_capacity>25 and dr.weigt_limit>=?1\n",nativeQuery = true)
    List<AvailableDrone> getAvailableDroneForLoading(double loadweight);


}
