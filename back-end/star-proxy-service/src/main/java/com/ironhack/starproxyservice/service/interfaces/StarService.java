package com.ironhack.starproxyservice.service.interfaces;

import com.ironhack.starproxyservice.controller.dto.StarCuriousDTO;
import com.ironhack.starproxyservice.controller.dto.StarDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StarService {
    List<StarDTO> astronomicalInformation();
    List<StarCuriousDTO> curiousInformation();
    List<StarDTO> astronomicalInformationByConstellation(String constellation);
    List<StarCuriousDTO> curiousInformationByConstellation(String constellation);
    StarDTO astronomicalInformationStarById(long SAO);
    StarCuriousDTO curiousInformationStarById(long SAO);
}
