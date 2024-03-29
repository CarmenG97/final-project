package com.ironhack.coordinateproxyservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class StarCoordinates {

    //Cambiar estos valores a bigDecimal
    @Id
    @Column(name="sao")
    private long SAO;  //StarId
    private double rightAscension;
    private double declination;

    private BigDecimal distance;

    public StarCoordinates() {
    }

    public StarCoordinates(long SAO, double rightAscension, double declination, BigDecimal distance) {
        this.SAO = SAO;
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
}
