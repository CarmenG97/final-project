package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.AmateurAttendEventDTO;
import com.ironhack.edgeservice.controller.dto.EventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@FeignClient("event-proxy-service")
public interface EventServiceClient {

    @GetMapping("/events")
    List<EventDTO> findAll();

    @GetMapping("events/{id}")
    EventDTO findById(@PathVariable long id);

    @GetMapping("/events/amateur")
    List<AmateurAttendEventDTO> getAllEventsOfAmateur();

    @PostMapping("/events/amateur")
    AmateurAttendEventDTO addEventToAmateur(@RequestBody AmateurAttendEventDTO amateurAttendEventDTO);
}
