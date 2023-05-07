package com.project.drone.repositories;

import com.project.drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Integer> {
}
