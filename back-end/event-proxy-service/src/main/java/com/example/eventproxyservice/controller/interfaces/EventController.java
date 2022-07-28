package com.example.eventproxyservice.controller.interfaces;
import com.example.eventproxyservice.model.Event;

import java.util.List;

public interface EventController {

    List<Event> findAll();
    Event findById(long id);
}
