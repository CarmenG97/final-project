package com.ironhack.constellationproxyservice.controller.dto;

import java.math.BigDecimal;

public class StarCuriousDTO {
    private long SAO;
    private String starName;
    private String starDesignation;
    private String constellation;
    private String constellationId;

    private double brightness;  // brillo
    private String type;
    private String colour;
    private String image;
    private BigDecimal distance;

    public StarCuriousDTO() {
    }

    public StarCuriousDTO(long SAO, String starName, String starDesignation, String constellation, String constellationId, double brightness, String type, String colour, String image, BigDecimal distance) {
        this.SAO = SAO;
        this.starName = starName;
        this.starDesignation = starDesignation;
        this.constellation = constellation;
        this.constellationId = constellationId;
        this.brightness = brightness;
        this.type = type;
        this.colour = colour;
        this.image = image;
        this.distance = distance;
    }

    public long getSAO() {
        return SAO;
    }

    public String getStarName() {
        return starName;
    }

    public double getBrightness() {
        return brightness;
    }

    public String getColour() {
        return colour;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setSAO(long SAO) {
        this.SAO = SAO;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(String constellationId) {
        this.constellationId = constellationId;
    }
}
