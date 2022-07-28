package com.ironhack.starproxyservice.controller.dto;

import java.math.BigDecimal;

public class StarCoordinatesDTO {
    private String hemisphere;
    private BigDecimal distance;

    public StarCoordinatesDTO() {
    }

    public StarCoordinatesDTO(String hemisphere, BigDecimal distance) {
        this.hemisphere = hemisphere;
        this.distance = distance;
    }

    public String getHemisphere() {
        return hemisphere;
    }

    public void setHemisphere(String hemisphere) {
        this.hemisphere = hemisphere;
    }
    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
}
