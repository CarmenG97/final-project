package com.ironhack.starproxyservice.service.impl;

import com.ironhack.starproxyservice.client.CoordinateServiceClient;
import com.ironhack.starproxyservice.controller.dto.StarCoordinates;
import com.ironhack.starproxyservice.controller.dto.StarCoordinatesDTO;
import com.ironhack.starproxyservice.controller.dto.StarCuriousDTO;
import com.ironhack.starproxyservice.controller.dto.StarDTO;
import com.ironhack.starproxyservice.model.Star;
import com.ironhack.starproxyservice.repository.StarRepository;
import com.ironhack.starproxyservice.service.interfaces.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.Math;

@Service
public class StarServiceImpl implements StarService {
    @Autowired
    StarRepository starRepository;
    @Autowired
    CoordinateServiceClient coordinateServiceClient;

    public List<StarDTO> astronomicalInformation() {
        List<Star> starList = starRepository.findAll();
        List<StarCoordinates> starCoordinatesList = coordinateServiceClient.astronomicalInformation();

        List<StarDTO> starDTOList = new ArrayList<>();

        for(int i = 0; i < starList.size(); i++){

            StarDTO starDTO = new StarDTO(starList.get(i).getSAO(),
                    starList.get(i).getStarName(),
                    starList.get(i).getStarDesignation(),
                    starList.get(i).getConstellation(),
                    starList.get(i).getConstellationId(),
                    starList.get(i).getAppMagnitude(),
                    starList.get(i).getAbsMagnitude(),
                    starList.get(i).getSpectrum(),
                    starList.get(i).getColour(),
                    starList.get(i).getImage(),

                    starCoordinatesList.get(i).getRightAscension(),
                    starCoordinatesList.get(i).getDeclination(),
                    starCoordinatesList.get(i).getDistance());

            starDTOList.add(starDTO);

        }
        return starDTOList;

    }

    public List<StarCuriousDTO> curiousInformation() {
        List<Star> starList = starRepository.findAll();

        List<StarCoordinatesDTO> starCoordinatesDTOList = coordinateServiceClient.curiousInformation();

        List<StarCuriousDTO> starCuriousDTOList = new ArrayList<>();

        for (int i = 0; i < starList.size(); i++) {

            // Type
            String type = "";
            switch (starList.get(i).getSpectrum()) {
                case 1:
                    type = "Estrella supergigante";  // Falta hacer diferencia entre 1A y 1B
                    break;
                case 2:
                    type = "Estrella gigante luminosa";
                    break;
                case 3:
                    type = "Estrella gigante";
                    break;
                case 4:
                    type = "Estrella subgigante";
                    break;
                case 5:
                    type = "Estrella enana (S.P.)";
                    break;
                case 6:
                    type = "Estrella subenana";
                    break;
                case 7:
                    type = "Estrella enana blanca";
            }

            // Color
            String color = "";
            if(starList.get(i).getColour() < 0) {
                color = "azul";
            } else if (starList.get(i).getColour() == 0) {
                color = "blanca";
            } else if ((starList.get(i).getColour() > 0) && (starList.get(i).getColour() < 1.5)){
                color = "amarilla";
            } else if (starList.get(i).getColour() >= 1.5) {
                color = "roja";
            }

            // Brightness
            double mag = starList.get(i).getAppMagnitude();
            double flux = (Math.pow(10, -mag/2.5)/Math.pow(5.25, 10));
            BigDecimal fluxBigDecimal = new BigDecimal(flux);
            BigDecimal luminosity = starCoordinatesDTOList.get(i).getDistance().multiply(starCoordinatesDTOList.get(i).getDistance()).multiply(fluxBigDecimal);

            int brightness = luminosity.intValue();

            StarCuriousDTO starCuriousDTO = new StarCuriousDTO();
            starCuriousDTO.setSAO(starList.get(i).getSAO());
            starCuriousDTO.setStarName(starList.get(i).getStarName());
            starCuriousDTO.setStarDesignation(starList.get(i).getStarDesignation());
            starCuriousDTO.setConstellation(starList.get(i).getConstellation());
            starCuriousDTO.setConstellationId(starList.get(i).getConstellationId());

            starCuriousDTO.setBrightness(brightness);  //Calcularlo!!
            starCuriousDTO.setType(type);
            starCuriousDTO.setColour(color);
            starCuriousDTO.setImage(starList.get(i).getImage());
            starCuriousDTO.setDistance(starCoordinatesDTOList.get(i).getDistance());

            starCuriousDTOList.add(starCuriousDTO);
        }
        return starCuriousDTOList;
    }

    public List<StarDTO> astronomicalInformationByConstellation(@RequestParam String constellation){

        List<Star> starList = starRepository.findByConstellation(constellation);

        List<StarDTO> starDTOList = new ArrayList<>();

        for(int i = 0; i < starList.size(); i++){

            StarCoordinates starCoordinates = coordinateServiceClient.astronomicalInformationStarById(starList.get(i).getSAO());

            StarDTO starDTO = new StarDTO(starList.get(i).getSAO(),
                    starList.get(i).getStarName(),
                    starList.get(i).getStarDesignation(),
                    starList.get(i).getConstellation(),
                    starList.get(i).getConstellationId(),
                    starList.get(i).getAppMagnitude(),
                    starList.get(i).getAbsMagnitude(),
                    starList.get(i).getSpectrum(),
                    starList.get(i).getColour(),
                    starList.get(i).getImage(),

                    starCoordinates.getRightAscension(),
                    starCoordinates.getDeclination(),
                    starCoordinates.getDistance());

            starDTOList.add(starDTO);

        }
        return starDTOList;

    }


    public List<StarCuriousDTO> curiousInformationByConstellation(@RequestParam String constellation){

        List<Star> starList = starRepository.findByConstellation(constellation);

        List<StarCuriousDTO> starCuriousDTOList = new ArrayList<>();

        for(int i = 0; i < starList.size(); i++){

            StarCoordinatesDTO starCoordinatesDTO = coordinateServiceClient.curiousInformationStarById(starList.get(i).getSAO());

            String type = "";
            switch (starList.get(i).getSpectrum()) {
                case 1:
                    type = "Estrella supergigante";  // Falta hacer diferencia entre 1A y 1B
                    break;
                case 2:
                    type = "Estrella gigante luminosa";
                    break;
                case 3:
                    type = "Estrella gigante";
                    break;
                case 4:
                    type = "Estrella subgigante";
                    break;
                case 5:
                    type = "Estrella enana (S.P.)";
                    break;
                case 6:
                    type = "Estrella subenana";
                    break;
                case 7:
                    type = "Estrella enana blanca";
            }

            // Color
            String color = "";
            if(starList.get(i).getColour() < 0) {
                color = "azul";
            } else if (starList.get(i).getColour() == 0) {
                color = "blanca";
            } else if ((starList.get(i).getColour() > 0) && (starList.get(i).getColour() < 1.5)){
                color = "amarilla";
            } else if (starList.get(i).getColour() >= 1.5) {
                color = "roja";
            }


            // Brightness
            double mag = starList.get(i).getAppMagnitude();
            double flux = (Math.pow(10, -mag/2.5)/Math.pow(5.25, 10));
            BigDecimal fluxBigDecimal = new BigDecimal(flux);
            BigDecimal luminosity = starCoordinatesDTO.getDistance().multiply(starCoordinatesDTO.getDistance()).multiply(fluxBigDecimal);

            int brightness = luminosity.intValue();


            StarCuriousDTO starCuriousDTO = new StarCuriousDTO();

            starCuriousDTO.setSAO(starList.get(i).getSAO());
            starCuriousDTO.setStarName(starList.get(i).getStarName());
            starCuriousDTO.setStarDesignation(starList.get(i).getStarDesignation());
            starCuriousDTO.setConstellation(starList.get(i).getConstellation());
            starCuriousDTO.setConstellationId(starList.get(i).getConstellationId());

            // falta color y brillo
            //Voy a probar con valores inventados para ver si compila
            starCuriousDTO.setBrightness(brightness);
            starCuriousDTO.setType(type);

            starCuriousDTO.setColour(color);
            starCuriousDTO.setImage(starList.get(i).getImage());
            // La distancia la cogemos del otro proxy mediante el client
            starCuriousDTO.setDistance(starCoordinatesDTO.getDistance()); //Cambiar, inventado

            starCuriousDTOList.add(starCuriousDTO);
        }
        return starCuriousDTOList;

    }


    public StarDTO astronomicalInformationStarById(long SAO) {
        StarCoordinates starCoordinates = coordinateServiceClient.astronomicalInformationStarById(SAO);

        Optional<Star> optionalStar = starRepository.findById(SAO);


        StarDTO starDTO = new StarDTO(optionalStar.get().getSAO(),
                // Star information
                optionalStar.get().getStarName(),
                optionalStar.get().getStarDesignation(),
                optionalStar.get().getConstellation(),
                optionalStar.get().getConstellationId(),
                optionalStar.get().getAppMagnitude(),
                optionalStar.get().getAbsMagnitude(),
                optionalStar.get().getSpectrum(),
                optionalStar.get().getColour(),
                optionalStar.get().getImage(),

                // Star coordinates information
                starCoordinates.getRightAscension(),
                starCoordinates.getDeclination(),
                starCoordinates.getDistance());

        return starDTO;
    }


    public StarCuriousDTO curiousInformationStarById(long SAO){

        StarCoordinatesDTO starCoordinatesDTO = coordinateServiceClient.curiousInformationStarById(SAO);

        Optional<Star> optionalStar = starRepository.findById(SAO);

        // Transform the type
        String type = "";

        switch (optionalStar.get().getSpectrum()) {
            case 1:
                type = "Estrella supergigante";  // Falta hacer diferencia entre 1A y 1B
                break;
            case 2:
                type = "Estrella gigante luminosa";
                break;
            case 3:
                type = "Estrella gigante";
                break;
            case 4:
                type = "Estrella subgigante";
                break;
            case 5:
                type = "Estrella enana (S.P.)";
                break;
            case 6:
                type = "Estrella subenana";
                break;
            case 7:
                type = "Estrella enana blanca";
        }

        // Colour
        String color = "";
        if(optionalStar.get().getColour() < 0) {
            color = "azul";
        } else if (optionalStar.get().getColour() == 0) {
            color = "blanca";
        } else if ((optionalStar.get().getColour() > 0) && (optionalStar.get().getColour() < 1.5)){
            color = "amarilla";
        } else if (optionalStar.get().getColour() >= 1.5) {
            color = "roja";
        }


        // Brightness
        double mag = optionalStar.get().getAppMagnitude();
        double flux = (Math.pow(10, -mag/2.5)/Math.pow(5.25, 10)); // In solar flux units
        BigDecimal fluxBigDecimal = new BigDecimal(flux);
        BigDecimal luminosity = starCoordinatesDTO.getDistance().multiply(starCoordinatesDTO.getDistance()).multiply(fluxBigDecimal);

        int brightness = luminosity.intValue();


        StarCuriousDTO starCuriousDTO = new StarCuriousDTO();

             starCuriousDTO.setSAO(optionalStar.get().getSAO());
             starCuriousDTO.setStarName(optionalStar.get().getStarName());
             starCuriousDTO.setStarDesignation(optionalStar.get().getStarDesignation());
             starCuriousDTO.setConstellation(optionalStar.get().getConstellation());
             starCuriousDTO.setConstellationId(optionalStar.get().getConstellationId());

             // falta color y brillo
             //Voy a probar con valores inventados para ver si compila
             starCuriousDTO.setBrightness(brightness);
             starCuriousDTO.setType(type);

             starCuriousDTO.setColour(color);
             starCuriousDTO.setImage(optionalStar.get().getImage());
             // La distancia la cogemos del otro proxy mediante el client
             starCuriousDTO.setDistance(starCoordinatesDTO.getDistance()); //Cambiar, inventado


        return starCuriousDTO;
    }
}
