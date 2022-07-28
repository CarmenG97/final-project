package com.example.amateurproxyservice.controller.impl;

import com.example.amateurproxyservice.controller.dto.AmateurDTO;
import com.example.amateurproxyservice.controller.dto.RoleDTO;
import com.example.amateurproxyservice.controller.interfaces.AmateurController;
import com.example.amateurproxyservice.model.Amateur;
import com.example.amateurproxyservice.model.Role;
import com.example.amateurproxyservice.service.interfaces.AmateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AmateurControllerImpl implements AmateurController {
    @Autowired
    private AmateurService amateurService;

    @PostMapping("/amateurs")
    @ResponseStatus(HttpStatus.CREATED)
    public AmateurDTO register(@RequestBody AmateurDTO amateurDTO){
        return amateurService.store(amateurDTO);
    }

    @GetMapping("/amateurs")
    @ResponseStatus(HttpStatus.OK)
    public List<AmateurDTO> findAll() {
        return amateurService.findAll();
    }


    @GetMapping("/amateurs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Amateur getAmateurById(@PathVariable long id){
        return amateurService.getAmateurById(id);
    }

    @GetMapping("/amateur/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Amateur> getAmateurByName(@PathVariable String name) {
        return amateurService.getAmateurByName(name);
    }

    private AmateurDTO amateurToDTO(Amateur amateur) {
        AmateurDTO amateurDTO = new AmateurDTO();
        amateurDTO.setName(amateur.getName());
        amateurDTO.setPassword(amateur.getPassword());
  //      amateurDTO.setRoles(amateur.getRoles().stream().map(this::roleToDTO).collect(Collectors.toSet()));

        return amateurDTO;
    }

    private RoleDTO roleToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getName());

        return roleDTO;
    }


}
