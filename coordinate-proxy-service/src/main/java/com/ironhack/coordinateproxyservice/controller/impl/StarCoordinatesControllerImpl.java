package com.ironhack.coordinateproxyservice.controller.impl;

import com.ironhack.coordinateproxyservice.controller.dto.StarCoordinatesDTO;
import com.ironhack.coordinateproxyservice.controller.interfaces.StarCoordinatesController;
import com.ironhack.coordinateproxyservice.model.StarCoordinates;
import com.ironhack.coordinateproxyservice.repository.StarCoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@RestController
public class StarCoordinatesControllerImpl implements StarCoordinatesController {

    final BigDecimal SUN_DISTANCE = new BigDecimal("0.000016"); // Comprobar que final va así y con mayúsculas
    // El valor exacto es "0.00001581"

    @Autowired
    public StarCoordinatesRepository starCoordinatesRepository;

    @GetMapping("/stars/coordinates")
    @ResponseStatus(HttpStatus.OK)
    public List<StarCoordinates> astronomicalInformation() {
        return starCoordinatesRepository.findAll();
    }


    @GetMapping("/stars/coordinates/astronomical/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarCoordinates astronomicalInformationStarById(@PathVariable  long SAO) {

        Optional<StarCoordinates> optionalStarCoordinates = starCoordinatesRepository.findById(SAO);

        return optionalStarCoordinates.get();
    }

    @GetMapping("/stars/coordinates/curious/{SAO}")
    @ResponseStatus(HttpStatus.OK)
    public StarCoordinatesDTO curiousInformationStarById(@PathVariable  long SAO) {

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
        starCoordinatesDTO.setCardinalPoints("West");   // Ejemplo
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
