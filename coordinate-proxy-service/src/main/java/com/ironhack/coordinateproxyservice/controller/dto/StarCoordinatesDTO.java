package com.ironhack.coordinateproxyservice.controller.dto;

import java.math.BigDecimal;

public class StarCoordinatesDTO {
    private String hemisphere;
    private String cardinalPoints;
    private BigDecimal distance;

    public StarCoordinatesDTO() {
    }

    public StarCoordinatesDTO(String hemisphere, String cardinalPoints, BigDecimal distance) {
        this.hemisphere = hemisphere;
        this.cardinalPoints = cardinalPoints;
        this.distance = distance;
    }

    public String getHemisphere() {
        return hemisphere;
    }

    public void setHemisphere(String hemisphere) {
        this.hemisphere = hemisphere;
    }

    public String getCardinalPoints() {
        return cardinalPoints;
    }

    public void setCardinalPoints(String cardinalPoints) {
        this.cardinalPoints = cardinalPoints;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
}
