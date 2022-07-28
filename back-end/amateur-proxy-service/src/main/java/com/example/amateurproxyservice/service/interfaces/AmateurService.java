package com.example.amateurproxyservice.service.interfaces;

import com.example.amateurproxyservice.controller.dto.AmateurDTO;
import com.example.amateurproxyservice.model.Amateur;

import java.util.List;
import java.util.Optional;

public interface AmateurService {

    AmateurDTO store(AmateurDTO amateur);
    List<AmateurDTO> findAll();
    Amateur getAmateurById(Long id);
    Optional<Amateur> getAmateurByName(String name);

}