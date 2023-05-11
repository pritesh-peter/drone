package com.project.drone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "Only alphabets, numbers, '-', and '_' allowed")
    String name;

    double weight;

    @Pattern(regexp = "^[A-Z0-9_]+$", message = "Only capital alphabets, numbers, and underscores allowed")
    String medicationCode;

    String medicationImage;
}
