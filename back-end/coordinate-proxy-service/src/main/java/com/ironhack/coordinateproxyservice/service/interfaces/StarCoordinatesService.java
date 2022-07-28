package com.ironhack.coordinateproxyservice.service.interfaces;

import com.ironhack.coordinateproxyservice.controller.dto.StarCoordinatesDTO;

import java.util.List;

public interface StarCoordinatesService {

    List<StarCoordinatesDTO> curiousInformation();
    StarCoordinatesDTO curiousInformationStarById(long SAO);
}
