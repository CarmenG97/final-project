package com.ironhack.coordinateproxyservice.controller.interfaces;

import com.ironhack.coordinateproxyservice.controller.dto.StarCoordinatesDTO;
import com.ironhack.coordinateproxyservice.model.StarCoordinates;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StarCoordinatesController {
    List<StarCoordinates> astronomicalInformation();
    List<StarCoordinatesDTO> curiousInformation();
    StarCoordinates astronomicalInformationStarById(long SAO);
    StarCoordinatesDTO curiousInformationStarById(long SAO);

}
