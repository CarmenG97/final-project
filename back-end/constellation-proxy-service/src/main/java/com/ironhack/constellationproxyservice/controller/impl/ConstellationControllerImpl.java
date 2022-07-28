package com.ironhack.constellationproxyservice.controller.impl;

import com.ironhack.constellationproxyservice.controller.dto.ConstellationCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.ConstellationDTO;
import com.ironhack.constellationproxyservice.controller.dto.StarDTO;
import com.ironhack.constellationproxyservice.controller.interfaces.ConstellationController;
import com.ironhack.constellationproxyservice.repository.ConstellationRepository;
import com.ironhack.constellationproxyservice.service.interfaces.ConstellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConstellationControllerImpl implements ConstellationController {

    @Autowired
    private ConstellationRepository constellationRepository;
    @Autowired
    private ConstellationService constellationService;

    @GetMapping("/constellations/astronomical")
    @ResponseStatus(HttpStatus.OK)
    public List<ConstellationDTO> astronomicalInformation() {

        return constellationService.astronomicalInformation();
    }

    @GetMapping("/constellations")
    @ResponseStatus(HttpStatus.OK)
    public List<ConstellationCuriousDTO> curiousInformation() {

        return constellationService.curiousInformation();
    }


    @GetMapping("/constellations/astronomical/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConstellationDTO astronomicalInformationById(@PathVariable long id){
        return constellationService.astronomicalInformationById(id);
    }

    @GetMapping("/constellations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConstellationCuriousDTO curiousInformationById(@PathVariable long id){
        return constellationService.curiousInformationById(id);
    }

}
