package com.ironhack.constellationproxyservice.controller.interfaces;

import com.ironhack.constellationproxyservice.controller.dto.ConstellationCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.ConstellationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface ConstellationController {

    List<ConstellationDTO> astronomicalInformation();
    List<ConstellationCuriousDTO> curiousInformation();

    ConstellationDTO astronomicalInformationById(@PathVariable long id);
    ConstellationCuriousDTO curiousInformationById(@PathVariable long id);


}
