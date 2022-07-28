package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.Amateur;
import com.ironhack.edgeservice.controller.dto.AmateurDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@FeignClient("amateur-proxy-service")
public interface AmateurServiceClient {

    @GetMapping("/amateurs/{id}")
    AmateurDTO getAmateurById(@PathVariable Long id);

    @PostMapping("/amateurs")
    AmateurDTO register(@RequestBody AmateurDTO amateurDTO);

    @GetMapping("/amateurs")
    List<AmateurDTO> findAll();

    @GetMapping("/login")
    AmateurDTO login();

    @GetMapping("/amateur/{name}")
    Optional<Amateur> getAmateurByName(@PathVariable String name);



}
