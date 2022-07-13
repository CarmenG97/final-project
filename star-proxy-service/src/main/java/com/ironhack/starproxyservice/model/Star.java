package com.ironhack.starproxyservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Star {

    @Id
    private long SAO;  // Nº de la estrella en el catálogo Smithsonian Astrophysical Observatory, que ha sido hasta la realización de los catálogos Tycho e Hipparcos, la fuente más fiable sobre las posiciones, brillos y coordenadas de las estrellas más brillantes del cielo.
    private double appMagnitude; // Apparent magnitude
    private double absMagnitude; // Absolute magnitude
    private int spectrum;
    private double colour;
 //   private Coordinates coordinates;
    private long distance;

    public Star() {
    }

    public Star(long SAO, double appMagnitude, double absMagnitude, int spectrum, double colour, Coordinates coordinates, long distance) {
        this.SAO = SAO;
        this.appMagnitude = appMagnitude;
        this.absMagnitude = absMagnitude;
        this.spectrum = spectrum;
        this.colour = colour;
   //     this.coordinates = coordinates;
        this.distance = distance;
    }

    public long getSAO() {
        return SAO;
    }

    public void setSAO(long SAO) {
        this.SAO = SAO;
    }

    public double getAppMagnitude() {
        return appMagnitude;
    }

    public void setAppMagnitude(double appMagnitude) {
        this.appMagnitude = appMagnitude;
    }

    public double getAbsMagnitude() {
        return absMagnitude;
    }

    public void setAbsMagnitude(double absMagnitude) {
        this.absMagnitude = absMagnitude;
    }

    public int getSpectrum() {
        return spectrum;
    }

    public void setSpectrum(int spectrum) {
        this.spectrum = spectrum;
    }

    public double getColour() {
        return colour;
    }

    public void setColour(double colour) {
        this.colour = colour;
    }

    /*
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


     */
    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}
