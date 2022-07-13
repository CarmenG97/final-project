package com.ironhack.starproxyservice.model;

public class Coordinates {
    private double rightAscension;
    private double declination;

    public Coordinates() {
    }

    public Coordinates(double rightAscension, double declination) {
        this.rightAscension = rightAscension;
        this.declination = declination;
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
}
