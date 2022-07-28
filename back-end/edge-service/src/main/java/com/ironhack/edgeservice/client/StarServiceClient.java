package com.ironhack.edgeservice.client;
import com.ironhack.edgeservice.controller.dto.StarCuriousDTO;
import com.ironhack.edgeservice.controller.dto.StarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
