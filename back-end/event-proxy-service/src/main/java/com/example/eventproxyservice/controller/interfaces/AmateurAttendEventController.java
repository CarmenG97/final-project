package com.example.eventproxyservice.controller.interfaces;

import com.example.eventproxyservice.model.AmateurAttendEvent;

import java.util.List;

public interface AmateurAttendEventController {

    List<AmateurAttendEvent> getAllEventsOfAmateur();
    AmateurAttendEvent addEventToAmateur(AmateurAttendEvent amateurAttendEvent);
}
