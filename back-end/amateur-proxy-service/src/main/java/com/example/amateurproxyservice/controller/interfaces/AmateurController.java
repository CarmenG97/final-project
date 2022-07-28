package com.example.amateurproxyservice.controller.interfaces;

import com.example.amateurproxyservice.controller.dto.AmateurDTO;
import com.example.amateurproxyservice.model.Amateur;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface AmateurController {

    List<AmateurDTO> findAll();

    AmateurDTO register(AmateurDTO amateurDTO);

    Amateur getAmateurById(long id);

    Optional<Amateur> getAmateurByName(String name);

}
