package com.ironhack.constellationproxyservice.client;

import com.ironhack.constellationproxyservice.controller.dto.StarCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.StarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
@FeignClient("star-proxy-service")
public interface StarServiceClient {

    @GetMapping("/stars/astronomical")
    List<StarDTO> astronomicalInformation();

    @GetMapping("/stars")
    List<StarCuriousDTO> curiousInformation();
    @GetMapping("/stars/constellation/astronomical")
    List<StarDTO> astronomicalInformationByConstellation(@RequestParam String constellation);
    @GetMapping("/stars/constellation")
    List<StarCuriousDTO> curiousInformationByConstellation(@RequestParam String constellation);

    @GetMapping("/stars/astronomical/{SAO}")
    StarDTO astronomicalInformationStarById(@PathVariable long SAO);

    @GetMapping("/stars/{SAO}")
    StarCuriousDTO curiousInformationStarById(@PathVariable long SAO);



}
