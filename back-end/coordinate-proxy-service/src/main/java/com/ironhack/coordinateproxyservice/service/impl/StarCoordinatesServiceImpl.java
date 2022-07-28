package com.ironhack.coordinateproxyservice.service.impl;

import com.ironhack.coordinateproxyservice.controller.dto.StarCoordinatesDTO;
import com.ironhack.coordinateproxyservice.model.StarCoordinates;
import com.ironhack.coordinateproxyservice.repository.StarCoordinatesRepository;
import com.ironhack.coordinateproxyservice.service.interfaces.StarCoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StarCoordinatesServiceImpl implements StarCoordinatesService {

    final BigDecimal SUN_DISTANCE = new BigDecimal("0.000016"); // Comprobar que final va así y con mayúsculas
    // El valor exacto es "0.00001581"

    @Autowired
    private StarCoordinatesRepository starCoordinatesRepository;


    public List<StarCoordinatesDTO> curiousInformation() {

        List<StarCoordinates> starCoordinatesList = starCoordinatesRepository.findAll();

        List<StarCoordinatesDTO> starCoordinatesDTOList = new ArrayList<>();

        for(int i = 0; i < starCoordinatesList.size(); i++) {

            StarCoordinatesDTO starCoordinatesDTO = new StarCoordinatesDTO();

            String hemisphere = "";

            // Calculo si la estrella esta en el hemisferio norte o sur (declinacion norte de 0 a 90º, sur de 0 a -90º)
            // Cambiar por switch
            if (starCoordinatesList.get(i).getDeclination() > 0 && starCoordinatesList.get(i).getDeclination() < 90.0) {
                hemisphere = "North hemisphere";
            } else { // Comprobar esto bien
                hemisphere = "South hemisphere";
            }

            // Calculo la distancia en función de la distancia al Sol (paso de años luz a distancia Solar)
            BigDecimal lightYearDistance = starCoordinatesList.get(i).getDistance();
            BigDecimal distanceInSolarDistance = lightYearDistance.divide(SUN_DISTANCE);

            //El número es "0.00001581" pero al ponerlo así no sale. Arreglar!!

            starCoordinatesDTO.setHemisphere(hemisphere); // Ejemplo
            starCoordinatesDTO.setDistance(distanceInSolarDistance.setScale(0, RoundingMode.HALF_UP));
            // Distance from lightyear to Sun distance


            //Declarar la distancia al Sol en años luz como tipo final (hecho)

            // Esto es las veces que esa estrella está más lejos que el Sol. Luego, tiene que ser entero (hecho)
            // Aquí hay que tener en cuenta que las estrellas de una constelación pueden estar más lejos que la propia constelacion
            // Lo cuento porque est interesante

            // Con ascension recta y declinación hago lo mismo. Busco que valores para hemisferio norte o sur y este o oeste
            // Pasar a bigDecimal y que te devuelva 0 decimales, como si fuera entero

            starCoordinatesDTOList.add(starCoordinatesDTO);
        }

        return starCoordinatesDTOList;

    }

    public StarCoordinatesDTO curiousInformationStarById(long SAO) {
        Optional<StarCoordinates> optionalStarCoordinates = starCoordinatesRepository.findById(SAO);

        StarCoordinatesDTO starCoordinatesDTO = new StarCoordinatesDTO();

        String hemisphere = "";

        // Calculo si la estrella esta en el hemisferio norte o sur (declinacion norte de 0 a 90º, sur de 0 a -90º)
        // Cambiar por switch
        if(optionalStarCoordinates.get().getDeclination() > 0 && optionalStarCoordinates.get().getDeclination() < 90.0) {
            hemisphere = "North hemisphere";
        } else { // Comprobar esto bien
            hemisphere = "South hemisphere";
        }

        // Calculo de los puntos cardinales

        // Calculo la distancia en función de la distancia al Sol (paso de años luz a distancia Solar)
        BigDecimal lightYearDistance = optionalStarCoordinates.get().getDistance();
        BigDecimal distanceInSolarDistance = lightYearDistance.divide(SUN_DISTANCE);

        //El número es "0.00001581" pero al ponerlo así no sale. Arreglar!!

        starCoordinatesDTO.setHemisphere(hemisphere); // Ejemplo
        starCoordinatesDTO.setDistance(distanceInSolarDistance.setScale(0, RoundingMode.HALF_UP));
        // Distance from lightyear to Sun distance


        //Declarar la distancia al Sol en años luz como tipo final (hecho)

        // Esto es las veces que esa estrella está más lejos que el Sol. Luego, tiene que ser entero (hecho)
        // Aquí hay que tener en cuenta que las estrellas de una constelación pueden estar más lejos que la propia constelacion
        // Lo cuento porque est interesante

        // Con ascension recta y declinación hago lo mismo. Busco que valores para hemisferio norte o sur y este o oeste
        // Pasar a bigDecimal y que te devuelva 0 decimales, como si fuera entero

        return starCoordinatesDTO;
    }
}
