package com.ironhack.starproxyservice.controller.interfaces;

import com.ironhack.starproxyservice.controller.dto.StarCoordinates;
import com.ironhack.starproxyservice.controller.dto.StarCuriousDTO;
import com.ironhack.starproxyservice.controller.dto.StarDTO;
import com.ironhack.starproxyservice.model.Star;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StarController {
    List<StarDTO> astronomicalInformation();
    List<StarCuriousDTO> curiousInformation();
    List<StarDTO> astronomicalInformationByConstellation(String constellation);
    List<StarCuriousDTO> curiousInformationByConstellation(String constellation);
    StarDTO astronomicalInformationStarById(long SAO);
    StarCuriousDTO curiousInformationStarById(long SAO);
}
