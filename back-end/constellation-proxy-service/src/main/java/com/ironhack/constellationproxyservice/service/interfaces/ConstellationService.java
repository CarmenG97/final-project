package com.ironhack.constellationproxyservice.service.interfaces;


import com.ironhack.constellationproxyservice.controller.dto.ConstellationCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.ConstellationDTO;
import com.ironhack.constellationproxyservice.controller.dto.StarDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ConstellationService {
    List<ConstellationDTO> astronomicalInformation();
    List<ConstellationCuriousDTO> curiousInformation();
    ConstellationDTO astronomicalInformationById(long id);
    ConstellationCuriousDTO curiousInformationById(long id);



}
