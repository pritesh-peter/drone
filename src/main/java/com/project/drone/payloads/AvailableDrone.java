package com.project.drone.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface AvailableDrone {

    Integer getId();

    Integer getLoadedWeight();

    Integer getAvailableWeightLimit();


}
