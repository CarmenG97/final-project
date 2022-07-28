package com.example.eventproxyservice.service.impl;

import com.example.eventproxyservice.model.AmateurAttendEvent;
import com.example.eventproxyservice.model.Event;
import com.example.eventproxyservice.repository.AmateurAttendEventRepository;
import com.example.eventproxyservice.service.interfaces.AmateurAttendEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmateurAttendEventServiceImpl implements AmateurAttendEventService {

    @Autowired
    private AmateurAttendEventRepository amateurAttendEventRepository;

    public List<AmateurAttendEvent> getAllEventsOfAmateur(){
        return amateurAttendEventRepository.findAll();
    }

    public AmateurAttendEvent addEventToAmateur(AmateurAttendEvent amateurAttendEvent){
        return amateurAttendEventRepository.save(amateurAttendEvent);
    }
}
