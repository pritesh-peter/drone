package com.project.drone.service.impl;

import com.project.drone.model.Drone;
import com.project.drone.model.EventLog;
import com.project.drone.repositories.EventLogRepository;
import com.project.drone.service.DroneService;
import com.project.drone.service.EventLogService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EventLogServiceImpl implements EventLogService {

    private final EventLogRepository eventLogRepository;

    private final DroneService droneService;

    public EventLogServiceImpl(EventLogRepository eventLogRepository, DroneService droneService){
        this.eventLogRepository = eventLogRepository;
        this.droneService = droneService;
    }
    @Override
    public Boolean createDroneBatteryStatusLog(Drone drone) {

        Drone validateDrone = droneService.findDroneById(drone.getId());
        if(validateDrone!=null) {
            EventLog newLog = new EventLog();
            newLog.setDroneId(drone.getId());
            newLog.setBatteryStatus(drone.getBatteryCapacity());
            newLog.setEventTimeStamp(new Date());
            eventLogRepository.save(newLog);

            validateDrone.setBatteryCapacity(drone.getBatteryCapacity());
            droneService.updateDrone(validateDrone);
        return true;
        }
        return false;
    }
}
