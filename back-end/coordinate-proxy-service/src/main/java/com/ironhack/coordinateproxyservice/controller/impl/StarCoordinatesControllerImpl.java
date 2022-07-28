package com.ironhack.coordinateproxyservice.controller.impl;

import com.ironhack.coordinateproxyservice.controller.dto.StarCoordinatesDTO;
import com.ironhack.coordinateproxyservice.controller.interfaces.StarCoordinatesController;
import com.ironhack.coordinateproxyservice.model.StarCoordinates;
import com.ironhack.coordinateproxyservice.repository.StarCoordinatesRepository;
import com.ironhack.coordinateproxyservice.service.interfaces.StarCoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@RestController
public class StarCoordinatesControllerImpl implements StarCoordinatesController {

    @Autowired
    public StarCoordinatesRepository starCoordinatesRepository;

    @Autowired
    public StarCoordinatesService starCoordinatesService;


    // Coordinates of all stars
    @GetMapping("/stars/coordinates/astronomical")
    @ResponseStatus(HttpStatus.OK)
    public List<StarCoordinates> astronomicalInformation() {
        return starCoordinatesRepository.findAll();
    }

    @GetMapping("stars/coordinates")
    @ResponseStatus(HttpStatus.OK)
    public List<StarCoordinatesDTO> curiousInformation() {
        return starCoordinatesService.curiousInformation();
    }


    // Physicists
    // Coordinates of a specific star (SAO id)
    @GetMapping("/stars/coordinates/astronomical/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarCoordinates astronomicalInformationStarById(@PathVariable  long SAO) {

        Optional<StarCoordinates> optionalStarCoordinates = starCoordinatesRepository.findById(SAO);

        return optionalStarCoordinates.get();
    }

    // Curious people
    // Cordinates of a specific star (SAO id)
    @GetMapping("/stars/coordinates/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarCoordinatesDTO curiousInformationStarById(@PathVariable  long SAO) {

        return starCoordinatesService.curiousInformationStarById(SAO);

    }

}
