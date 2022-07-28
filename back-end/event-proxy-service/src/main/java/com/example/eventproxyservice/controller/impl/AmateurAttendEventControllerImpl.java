package com.example.eventproxyservice.controller.impl;
import com.example.eventproxyservice.model.AmateurAttendEvent;
import com.example.eventproxyservice.model.Event;
import com.example.eventproxyservice.repository.AmateurAttendEventRepository;
import com.example.eventproxyservice.service.impl.AmateurAttendEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AmateurAttendEventControllerImpl {

    @Autowired
    private AmateurAttendEventServiceImpl amateurAttendEventService;

    @GetMapping("/events/amateur")
    @ResponseStatus(HttpStatus.OK)
    public List<AmateurAttendEvent> getAllEventsOfAmateur(){
        return amateurAttendEventService.getAllEventsOfAmateur();
    }

    //Despues /events/amateur/{userId}

    @PostMapping("/events/amateur")
    @ResponseStatus(HttpStatus.CREATED)
    public AmateurAttendEvent addEventToAmateur(@RequestBody AmateurAttendEvent amateurAttendEvent) {
        return amateurAttendEventService.addEventToAmateur(amateurAttendEvent);
    }
}
