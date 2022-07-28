package com.ironhack.constellationproxyservice.controller.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class StarDTO {
    private long SAO;  // Star id accordint to the catalogue of Smithsonian Astrophysical Observatory
    // Ha sido hasta la realización de los catálogos Tycho e Hipparcos, la fuente más fiable sobre las posiciones, brillos y coordenadas de las estrellas más brillantes del cielo.
    private String starName;
    private String starDesignation;
    private String constellation;
    private long constellationId;
    private double appMagnitude; // Apparent magnitude
    private double absMagnitude; // Absolute magnitude
    private int spectrum;
    private double colour;
    private String image;

    //Aquí iría la información de las coordenadas
    private double rightAscension;
    private double declination;

    private BigDecimal distance;

    public StarDTO() {
    }

    public StarDTO(long SAO, String starName, String starDesignation, String constellation, long constellationId, double appMagnitude, double absMagnitude, int spectrum, double colour, String image, double rightAscension, double declination, BigDecimal distance) {
        this.SAO = SAO;
        this.starName = starName;
        this.starDesignation = starDesignation;
        this.constellation = constellation;
        this.constellationId = constellationId;
        this.appMagnitude = appMagnitude;
        this.absMagnitude = absMagnitude;
        this.spectrum = spectrum;
        this.colour = colour;
        this.image = image;
        this.rightAscension = rightAscension;
        this.declination = declination;
        this.distance = distance;
    }

    public long getSAO() {
        return SAO;
    }

    public void setSAO(long SAO) {
        this.SAO = SAO;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
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

    public double getRightAscension() {
        return rightAscension;
    }

    public void setRightAscension(double rightAscension) {
        this.rightAscension = rightAscension;
    }

    public double getDeclination() {
        return declination;
    }

    public void setDeclination(double declination) {
        this.declination = declination;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getStarDesignation() {
        return starDesignation;
    }

    public void setStarDesignation(String starDesignation) {
        this.starDesignation = starDesignation;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(long constellationId) {
        this.constellationId = constellationId;
    }
}
