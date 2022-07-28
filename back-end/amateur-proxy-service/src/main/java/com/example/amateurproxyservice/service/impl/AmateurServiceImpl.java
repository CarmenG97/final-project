package com.example.amateurproxyservice.service.impl;

import com.example.amateurproxyservice.controller.dto.AmateurDTO;
import com.example.amateurproxyservice.controller.dto.RoleDTO;
import com.example.amateurproxyservice.model.Amateur;
import com.example.amateurproxyservice.model.Role;
import com.example.amateurproxyservice.repository.AmateurRepository;
import com.example.amateurproxyservice.service.interfaces.AmateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AmateurServiceImpl implements AmateurService {

    @Autowired
    AmateurRepository amateurRepository;

    public Amateur getAmateurById(Long id) {
        return amateurRepository.findById(id).get();
    }

    public AmateurDTO store(AmateurDTO amateurDTO) {
        Amateur amateur = toModel(amateurDTO);

        // Set default profile
       // amateur.setRoles(Set.of(new Role(null, "USER", amateur)));
        Amateur savedAmateur = amateurRepository.save(amateur);
        savedAmateur.setPassword(null);
        return toDTO(savedAmateur);
    }

    public List<AmateurDTO> findAll() {
        List<Amateur> amateurs = amateurRepository.findAll();
        List<AmateurDTO> response = amateurs.stream().map(this::toDTO).toList();

        return response;
    }

    public Optional<Amateur> getAmateurByName(String name) {
        return amateurRepository.findByName(name);
    }
    private Amateur toModel(AmateurDTO amateurDTO) {
        Amateur amateur = new Amateur();
        amateur.setName(amateurDTO.getName());
        amateur.setEmail(amateurDTO.getEmail());
        amateur.setYearsOfExperience(amateurDTO.getYearsOfExperience());
        amateur.setPassword(amateurDTO.getPassword());
        amateur.setPhoto(amateurDTO.getPhoto());

        return amateur;
    }

    private AmateurDTO toDTO(Amateur amateur) {
        AmateurDTO amateurDTO = new AmateurDTO();
        amateurDTO.setId(amateur.getId());
        amateurDTO.setName(amateur.getName());
        amateurDTO.setEmail(amateur.getEmail());
        amateurDTO.setYearsOfExperience(amateur.getYearsOfExperience());
        amateurDTO.setPassword(amateur.getPassword());
        amateurDTO.setPhoto(amateur.getPhoto());

        return amateurDTO;
    }

    private RoleDTO roleToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getName());

        return roleDTO;
    }
}
