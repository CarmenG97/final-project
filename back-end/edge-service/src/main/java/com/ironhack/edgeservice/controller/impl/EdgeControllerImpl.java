package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.*;
import com.ironhack.edgeservice.controller.interfaces.EdgeController;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class EdgeControllerImpl implements EdgeController {

    @Autowired
    EdgeService edgeService;

   // ------ CONSTELLATIONS -----

    @GetMapping("/constellations/astronomical")
    @ResponseStatus(HttpStatus.OK)
    public List<ConstellationDTO> astronomicalInformationConstellation() {
        return edgeService.astronomicalInformationConstellation();
    }

    @GetMapping("/constellations")
    @ResponseStatus(HttpStatus.OK)
    public List<ConstellationCuriousDTO> curiousInformationConstellation() {
        return edgeService.curiousInformationConstellation();
    }

    @GetMapping("/constellations/astronomical/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConstellationDTO astronomicalInformationConstellationById(@PathVariable long id) {
        return edgeService.astronomicalInformationConstellationById(id);
    }

    @GetMapping("/constellations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConstellationCuriousDTO curiousInformationConstellationById(@PathVariable long id){
        return edgeService.curiousInformationConstellationById(id);
    }

    // ----- STARS -----

    @GetMapping("/stars/astronomical")
    @ResponseStatus(HttpStatus.OK)
    public List<StarDTO> astronomicalInformationStar() {
        return edgeService.astronomicalInformationStar();
    }

    @GetMapping("/stars")
    @ResponseStatus(HttpStatus.OK)
    public List<StarCuriousDTO> curiousInformationStar() {
        return edgeService.curiousInformationStar();
    }

    @GetMapping("/stars/constellation/astronomical")
    @ResponseStatus(HttpStatus.OK)
    public List<StarDTO> astronomicalInformationByConstellation(@RequestParam String constellation){
        return edgeService.astronomicalInformationByConstellation(constellation);
    }

    @GetMapping("/stars/constellation")
    @ResponseStatus(HttpStatus.OK)
    public List<StarCuriousDTO> curiousInformationByConstellation(@RequestParam String constellation){
        return edgeService.curiousInformationByConstellation(constellation);
    }

    @GetMapping("/stars/astronomical/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarDTO astronomicalInformationStarById(@PathVariable long SAO) {
        return edgeService.astronomicalInformationStarById(SAO);
    }

    @GetMapping("/stars/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarCuriousDTO curiousInformationStarById(@PathVariable long SAO) {
        return edgeService.curiousInformationStarById(SAO);
    }


    //  ----- AMATEURS -----

    @PostMapping("/amateurs")
    @ResponseStatus(HttpStatus.CREATED)
    public AmateurDTO register(@RequestBody AmateurDTO amateurDTO){

        return edgeService.register(amateurDTO);
    }

    @GetMapping("/amateurs")
    @ResponseStatus(HttpStatus.OK)
    public List<AmateurDTO> findAll() {
        return edgeService.findAll();
    }

    @GetMapping("/amateurs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AmateurDTO getAmateurById(@PathVariable long id){
        return edgeService.getAmateurById(id);
    }

    @GetMapping("/amateur/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Amateur> getAmateurByName(@PathVariable String name) {
        return edgeService.getAmateurByName(name);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AmateurDTO login(@AuthenticationPrincipal Amateur amateur) {
        return edgeService.login(amateur);
    }

    // ----- EVENTS -----

    @GetMapping("/events")
    @ResponseStatus(HttpStatus.OK)
    public List<EventDTO> findAllEvents() {
        return edgeService.findAllEvents();
    }

    @GetMapping("events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventDTO findEventById(@PathVariable long id) {
        return edgeService.findEventById(id);
    }

    @GetMapping("/events/amateur")
    @ResponseStatus(HttpStatus.OK)
    public List<AmateurAttendEventDTO> getAllEventsOfAmateur(){
        return edgeService.getAllEventsOfAmateur();
    }

    @PostMapping("/events/amateur")
    @ResponseStatus(HttpStatus.CREATED)
    public AmateurAttendEventDTO addEventToAmateur(@RequestBody AmateurAttendEventDTO amateurAttendEventDTO) {
        return edgeService.addEventToAmateur(amateurAttendEventDTO);
    }
}
