package com.ironhack.constellationproxyservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Constellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String constellationName;
    private String alphaStarName;
    private int numberOfStars;
    private String profilePicture;
    private String secondProfilePicture;
    private String history;

    public Constellation() {
    }

    public Constellation(String constellationName, String alphaStarName, int numberOfStars, String profilePicture, String secondProfilePicture, String history) {
        this.constellationName = constellationName;
        this.alphaStarName = alphaStarName;
        this.numberOfStars = numberOfStars;
        this.profilePicture = profilePicture;
        this.secondProfilePicture = secondProfilePicture;
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSecondProfilePicture() {
        return secondProfilePicture;
    }

    public void setSecondProfilePicture(String secondProfilePicture) {
        this.secondProfilePicture = secondProfilePicture;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }

    public String getAlphaStarName() {
        return alphaStarName;
    }

    public void setAlphaStarName(String alphaStarName) {
        this.alphaStarName = alphaStarName;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

}
