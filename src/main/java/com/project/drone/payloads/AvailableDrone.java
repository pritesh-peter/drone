package com.project.drone.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface AvailableDrone {

    int getId();

    double getLoadedWeight();

    double getAvailableWeightLimit();


}
