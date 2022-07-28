package com.ironhack.constellationproxyservice.service.impl;

import com.ironhack.constellationproxyservice.client.StarServiceClient;
import com.ironhack.constellationproxyservice.controller.dto.ConstellationCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.ConstellationDTO;
import com.ironhack.constellationproxyservice.controller.dto.StarCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.StarDTO;
import com.ironhack.constellationproxyservice.model.Constellation;
import com.ironhack.constellationproxyservice.repository.ConstellationRepository;
import com.ironhack.constellationproxyservice.service.interfaces.ConstellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    @Autowired
    ConstellationRepository constellationRepository;
    @Autowired
    StarServiceClient starServiceClient;

    public List<ConstellationDTO> astronomicalInformation() {

        List<Constellation> constellationList = constellationRepository.findAll();


        List<ConstellationDTO> constellationDTOList = new ArrayList<>();


        for(int i = 0; i < constellationList.size(); i++){

            List<StarDTO> starByConstellation = starServiceClient.astronomicalInformationByConstellation(constellationList.get(i).getConstellationName());

                ConstellationDTO constellationDTO = new ConstellationDTO(
                        constellationList.get(i).getId(),
                        constellationList.get(i).getConstellationName(),
                        constellationList.get(i).getAlphaStarName(),
                        constellationList.get(i).getNumberOfStars(),
                        starByConstellation,
                        constellationList.get(i).getProfilePicture(),
                        "");

                constellationDTOList.add(constellationDTO);


        }


        return constellationDTOList;
    }


    public List<ConstellationCuriousDTO> curiousInformation() {

        List<Constellation> constellationList = constellationRepository.findAll();

        List<ConstellationCuriousDTO> constellationCuriousDTOList = new ArrayList<>();

        for(int i = 0; i < constellationList.size(); i++){

            String history = "";
            switch ((int) constellationList.get(i).getId()){
                case 1:
                    history = "Aries es más visible en el mes de noviembre. Para encontrar a Aries, busque una línea torcida de tres estrellas brillantes no muy lejos del cúmulo estelar de las Pléyades";
                    break;

                case 2:
                    history = "En el hemisferio norte, Taurus atraviesa el cielo de noviembre a marzo, pero la constelación es más visible en enero";
                    break;

                case 3:
                    history = "La constelación de Géminis se ve mejor durante febrero. Mira al noreste de la constelación de Orión y entre las constelaciones de Tauro y Cáncer y encontrarás sus dos estrellas brillantes que representan a Castor y Pollux";
                    break;

                case 4:
                    history = "Cáncer es visible en el hemisferio norte a principios de la primavera, y se puede ver en el hemisferio sur durante el otoño";
                    break;

                case 5:
                    history = "A principios de abril, la constelación de Leo alcanza su punto más alto durante la noche alrededor de las 10 pm en el hemisferio norte";
                break;

                case 6:
                    history = "Desde la perspectiva del hemisferio norte, Virgo está ausente del cielo durante finales de otoño, invierno y principios de primavera. Sin embargo, en marzo y abril, la constelación es visible toda la noche";
                    break;

                case 7:
                    history = "Libra es fácilmente observada en el hemisferio norte entre enero y julio";
                    break;

                case 8:
                    history = "Esta constelación tan sólo es visible durante la época del verano, incluso en algunos lugares del sur está incompleta";
                    break;

                case 9:
                    history = "El mejor mes para ver Sagitario en el hemisferio norte es en agosto";
                    break;

                case 10:
                    history = "Capricornio es una de las constelaciones de menos brillo y contiene sólo unos pocos objetos celestiales. Es más fácil ver a Capricornio durante el mes de septiembre";
                    break;

                case 11:
                    history = "Acuario se puede ver en la primavera en el hemisferio sur y el otoño en el hemisferio norte";
                    break;

                case 12:
                    history = "Piscis es visible entre febrero y marzo en el hemisferio norte";

            }

            List<StarCuriousDTO> starCuriousByConstellation = starServiceClient.curiousInformationByConstellation(constellationList.get(i).getConstellationName());

            ConstellationCuriousDTO constellationCuriousDTO = new ConstellationCuriousDTO(
                    constellationList.get(i).getId(),
                    constellationList.get(i).getConstellationName(),
                    constellationList.get(i).getAlphaStarName(),
                    constellationList.get(i).getNumberOfStars(),
                    starCuriousByConstellation,
                    constellationList.get(i).getProfilePicture(),
                    constellationList.get(i).getSecondProfilePicture(),
                    history);


            constellationCuriousDTOList.add(constellationCuriousDTO);


        }


        return constellationCuriousDTOList;
    }



    public ConstellationDTO astronomicalInformationById(long id){
        Optional<Constellation> constellation = constellationRepository.findById(id);

        List<StarDTO> starByConstellation = starServiceClient.astronomicalInformationByConstellation(constellation.get().getConstellationName());

        ConstellationDTO constellationDTO = new ConstellationDTO(
                constellation.get().getId(),
                constellation.get().getConstellationName(),
                constellation.get().getAlphaStarName(),
                constellation.get().getNumberOfStars(),
                starByConstellation,
                constellation.get().getProfilePicture(),
                "");

        return constellationDTO;

    }

    public ConstellationCuriousDTO curiousInformationById(long id){
        Optional<Constellation> constellation = constellationRepository.findById(id);

        List<StarCuriousDTO> starCuriousByConstellation = starServiceClient.curiousInformationByConstellation(constellation.get().getConstellationName());

        String history = "";
        switch ((int) constellation.get().getId()){
            case 1:
                history = "Aries es más visible en el mes de noviembre. Para encontrar a Aries, busque una línea torcida de tres estrellas brillantes no muy lejos del cúmulo estelar de las Pléyades";
                break;

            case 2:
                history = "En el hemisferio norte, Taurus atraviesa el cielo de noviembre a marzo, pero la constelación es más visible en enero";
                break;

            case 3:
                history = "La constelación de Géminis se ve mejor durante febrero. Mira al noreste de la constelación de Orión y entre las constelaciones de Tauro y Cáncer y encontrarás sus dos estrellas brillantes que representan a Castor y Pollux";
                break;

            case 4:
                history = "Cáncer es visible en el hemisferio norte a principios de la primavera, y se puede ver en el hemisferio sur durante el otoño";
                break;

            case 5:
                history = "A principios de abril, la constelación de Leo alcanza su punto más alto durante la noche alrededor de las 10 pm en el hemisferio norte";
                break;

            case 6:
                history = "Desde la perspectiva del hemisferio norte, Virgo está ausente del cielo durante finales de otoño, invierno y principios de primavera. Sin embargo, en marzo y abril, la constelación es visible toda la noche";
                break;

            case 7:
                history = "Libra es fácilmente observada en el hemisferio norte entre enero y julio";
                break;

            case 8:
                history = "Esta constelación tan sólo es visible durante la época del verano, incluso en algunos lugares del sur está incompleta";
                break;

            case 9:
                history = "El mejor mes para ver Sagitario en el hemisferio norte es en agosto";
                break;

            case 10:
                history = "Capricornio es una de las constelaciones de menos brillo y contiene sólo unos pocos objetos celestiales. Es más fácil ver a Capricornio durante el mes de septiembre";
                break;

            case 11:
                history = "Acuario se puede ver en la primavera en el hemisferio sur y el otoño en el hemisferio norte";
                break;

            case 12:
                history = "Piscis es visible entre febrero y marzo en el hemisferio norte";


        }

        ConstellationCuriousDTO constellationCuriousDTO = new ConstellationCuriousDTO(
                constellation.get().getId(),
                constellation.get().getConstellationName(),
                constellation.get().getAlphaStarName(),
                constellation.get().getNumberOfStars(),
                starCuriousByConstellation,
                constellation.get().getProfilePicture(),
                constellation.get().getSecondProfilePicture(),
                history);

        return constellationCuriousDTO;

    }


}