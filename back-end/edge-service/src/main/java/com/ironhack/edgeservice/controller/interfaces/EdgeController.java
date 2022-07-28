package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface EdgeController {
    List<ConstellationDTO> astronomicalInformationConstellation();
    List<ConstellationCuriousDTO> curiousInformationConstellation();
    ConstellationDTO astronomicalInformationConstellationById(long id);
    ConstellationCuriousDTO curiousInformationConstellationById(long id);
    List<StarDTO> astronomicalInformationStar();
    List<StarCuriousDTO> curiousInformationStar();
    List<StarDTO> astronomicalInformationByConstellation(String constellation);
    List<StarCuriousDTO> curiousInformationByConstellation(String constellation);
    StarDTO astronomicalInformationStarById(long SAO);
    StarCuriousDTO curiousInformationStarById(long SAO);
    AmateurDTO register(AmateurDTO amateurDTO);
    List<AmateurDTO> findAll();
    AmateurDTO getAmateurById(long id);
    Optional<Amateur> getAmateurByName(String name);
    AmateurDTO login(Amateur amateur);
    List<EventDTO> findAllEvents();
    EventDTO findEventById(long id);
    List<AmateurAttendEventDTO> getAllEventsOfAmateur();
    AmateurAttendEventDTO addEventToAmateur(AmateurAttendEventDTO amateurAttendEventDTO);
}
