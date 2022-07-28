package com.example.eventproxyservice.controller.impl;

import com.example.eventproxyservice.controller.interfaces.EventController;
import com.example.eventproxyservice.model.Event;
import com.example.eventproxyservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EventControllerImpl implements EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @GetMapping("events/{id}")
    public Event findById(@PathVariable long id) {
        return eventRepository.findById(id).get();
    }
}
