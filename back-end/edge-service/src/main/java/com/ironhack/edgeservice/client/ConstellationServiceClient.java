package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.ConstellationCuriousDTO;
import com.ironhack.edgeservice.controller.dto.ConstellationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("constellation-proxy-service")
public interface ConstellationServiceClient {
    @GetMapping("/constellations/astronomical")
    List<ConstellationDTO> astronomicalInformation();

    @GetMapping("/constellations")
    List<ConstellationCuriousDTO> curiousInformation();

    @GetMapping("/constellations/astronomical/{id}")
    ConstellationDTO astronomicalInformationById(@PathVariable long id);

    @GetMapping("/constellations/{id}")
    ConstellationCuriousDTO curiousInformationById(@PathVariable long id);

}