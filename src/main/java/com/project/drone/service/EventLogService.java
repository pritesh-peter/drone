package com.project.drone.service;

import com.project.drone.model.Drone;

public interface EventLogService {
    Boolean createDroneBatteryStatusLog(Drone droneId);
}
