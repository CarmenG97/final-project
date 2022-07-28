package com.ironhack.starproxyservice.client;

import com.ironhack.starproxyservice.controller.dto.StarCoordinates;
import com.ironhack.starproxyservice.controller.dto.StarCoordinatesDTO;
import com.ironhack.starproxyservice.controller.dto.StarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("coordinate-proxy-service")
public interface CoordinateServiceClient {

    @GetMapping("/stars/coordinates/astronomical")
    List<StarCoordinates> astronomicalInformation();
    @GetMapping("stars/coordinates")
    List<StarCoordinatesDTO> curiousInformation();
    @GetMapping("/stars/coordinates/{SAO}")
    StarCoordinatesDTO curiousInformationStarById(@PathVariable  long SAO);
    @GetMapping("/stars/coordinates/astronomical/{SAO}")
    StarCoordinates astronomicalInformationStarById(@PathVariable  long SAO);
}
