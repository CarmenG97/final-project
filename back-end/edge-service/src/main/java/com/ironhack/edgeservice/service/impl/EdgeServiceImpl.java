package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.AmateurServiceClient;
import com.ironhack.edgeservice.client.ConstellationServiceClient;
import com.ironhack.edgeservice.client.EventServiceClient;
import com.ironhack.edgeservice.client.StarServiceClient;
import com.ironhack.edgeservice.controller.dto.*;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    ConstellationServiceClient constellationServiceClient;
    @Autowired
    StarServiceClient starServiceClient;
    @Autowired
    AmateurServiceClient amateurServiceClient;

    @Autowired
    EventServiceClient eventServiceClient;

    @Autowired
    PasswordEncoder passwordEncoder;



    // ----- CONSTELLATIONS -----

    public List<ConstellationDTO> astronomicalInformationConstellation() {

        List<ConstellationDTO> constellationDTOS = constellationServiceClient.astronomicalInformation();
        return constellationDTOS;
    }

    public List<ConstellationCuriousDTO> curiousInformationConstellation() {

        List<ConstellationCuriousDTO> constellationCuriousDTOS = constellationServiceClient.curiousInformation();
        return constellationCuriousDTOS;
    }

    public ConstellationDTO astronomicalInformationConstellationById(long id) {
        ConstellationDTO constellationDTO = constellationServiceClient.astronomicalInformationById(id);
        return constellationDTO;
    }

    public ConstellationCuriousDTO curiousInformationConstellationById(long id){
        ConstellationCuriousDTO constellationCuriousDTO = constellationServiceClient.curiousInformationById(id);
        return constellationCuriousDTO;
    }

    // ----- STARS -----

    public List<StarDTO> astronomicalInformationStar() {

        return starServiceClient.astronomicalInformation();
    }


    public List<StarCuriousDTO> curiousInformationStar() {
        return starServiceClient.curiousInformation();
    }


    public List<StarDTO> astronomicalInformationByConstellation(String constellation){
        return starServiceClient.astronomicalInformationByConstellation(constellation);
    }


    public List<StarCuriousDTO> curiousInformationByConstellation(String constellation){
        return starServiceClient.curiousInformationByConstellation(constellation);
    }


    public StarDTO astronomicalInformationStarById(long SAO) {
        return starServiceClient.astronomicalInformationStarById(SAO);
    }


    public StarCuriousDTO curiousInformationStarById(long SAO) {
        return starServiceClient.curiousInformationStarById(SAO);
    }


    // ----- AMATEURS -----
    public AmateurDTO register(AmateurDTO amateurDTO){
        amateurDTO.setPassword(passwordEncoder.encode(amateurDTO.getPassword()));
        return amateurServiceClient.register(amateurDTO);
    }

    public List<AmateurDTO> findAll() {
        return amateurServiceClient.findAll();
    }

    public AmateurDTO getAmateurById(long id){
        return amateurServiceClient.getAmateurById(id);
    }

    public Optional<Amateur> getAmateurByName(String name) {

        return amateurServiceClient.getAmateurByName(name);
    }

    public AmateurDTO login(Amateur amateur) {
        amateur.setPassword(null);
        return amateurToDTO(amateur);
    }

    // ----- EVENTS -----

    public List<EventDTO> findAllEvents() {
        return eventServiceClient.findAll();
    }

    public EventDTO findEventById(long id) {
        return eventServiceClient.findById(id);
    }

    public List<AmateurAttendEventDTO> getAllEventsOfAmateur(){
        return eventServiceClient.getAllEventsOfAmateur();
    }

    public AmateurAttendEventDTO addEventToAmateur(AmateurAttendEventDTO amateurAttendEventDTO) {
        return eventServiceClient.addEventToAmateur(amateurAttendEventDTO);
    }


    private Amateur toModel(AmateurDTO amateurDTO) {
        Amateur amateur = new Amateur();
        amateur.setId(amateurDTO.getId());
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

        //    amateurDTO.setRoles(amateur.getRoles().stream().map(this::roleToDTO).collect(Collectors.toSet()));

        return amateurDTO;
    }

    private AmateurDTO amateurToDTO(Amateur amateur) {
        AmateurDTO amateurDTO = new AmateurDTO();
        amateurDTO.setId(amateur.getId());
        amateurDTO.setName(amateur.getName());
        amateurDTO.setEmail(amateur.getEmail());
        amateurDTO.setYearsOfExperience(amateur.getYearsOfExperience());
        amateurDTO.setPhoto(amateur.getPhoto());
        amateurDTO.setPassword(amateur.getPassword());

        return amateurDTO;
    }
}
