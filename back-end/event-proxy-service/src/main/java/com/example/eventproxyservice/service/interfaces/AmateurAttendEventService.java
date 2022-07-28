package com.example.eventproxyservice.service.interfaces;

import com.example.eventproxyservice.model.AmateurAttendEvent;
import java.util.List;

public interface AmateurAttendEventService {
    List<AmateurAttendEvent> getAllEventsOfAmateur();
    AmateurAttendEvent addEventToAmateur(AmateurAttendEvent amateurAttendEvent);
}
