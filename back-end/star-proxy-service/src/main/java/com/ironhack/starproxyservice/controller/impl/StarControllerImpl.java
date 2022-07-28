package com.ironhack.starproxyservice.controller.impl;

import com.ironhack.starproxyservice.client.CoordinateServiceClient;
import com.ironhack.starproxyservice.controller.dto.StarCoordinates;
import com.ironhack.starproxyservice.controller.dto.StarCuriousDTO;
import com.ironhack.starproxyservice.controller.dto.StarDTO;
import com.ironhack.starproxyservice.controller.interfaces.StarController;
import com.ironhack.starproxyservice.model.Star;
import com.ironhack.starproxyservice.repository.StarRepository;
import com.ironhack.starproxyservice.service.interfaces.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StarControllerImpl implements StarController {

    @Autowired
    StarRepository starRepository;

    @Autowired
    StarService starService;


    @GetMapping("/stars/astronomical")
    @ResponseStatus(HttpStatus.OK)
    public List<StarDTO> astronomicalInformation() {
        return starService.astronomicalInformation();
    }

    @GetMapping("/stars")
    @ResponseStatus(HttpStatus.OK)
    public List<StarCuriousDTO> curiousInformation() {
        return starService.curiousInformation();
    }

    @GetMapping("/stars/constellation/astronomical")
    @ResponseStatus(HttpStatus.OK)
    public List<StarDTO> astronomicalInformationByConstellation(@RequestParam String constellation){
        return starService.astronomicalInformationByConstellation(constellation);
    }

    @GetMapping("/stars/constellation")
    @ResponseStatus(HttpStatus.OK)
    public List<StarCuriousDTO> curiousInformationByConstellation(@RequestParam String constellation){
        return starService.curiousInformationByConstellation(constellation);
    }

    @GetMapping("/stars/astronomical/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarDTO astronomicalInformationStarById(@PathVariable long SAO) {
        return starService.astronomicalInformationStarById(SAO);
    }

    @GetMapping("/stars/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarCuriousDTO curiousInformationStarById(@PathVariable long SAO) {
        return starService.curiousInformationStarById(SAO);
    }



}
