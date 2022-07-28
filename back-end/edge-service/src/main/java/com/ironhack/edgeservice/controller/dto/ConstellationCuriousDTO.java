package com.ironhack.edgeservice.controller.dto;

import java.util.List;

public class ConstellationCuriousDTO {
    private long id;
    private String constellationName;
    private String alphaStarName;
    private int numberOfStars;
    private String profilePicture;

    private String secondProfilePicture;
    private List<StarCuriousDTO> starCuriousDTOList;

    private String history;

    public ConstellationCuriousDTO() {
    }

    public ConstellationCuriousDTO(long id, String constellationName, String alphaStarName, int numberOfStars, List<StarCuriousDTO> starCuriousDTOList, String profilePicture, String secondProfilePicture, String history) {
        this.id = id;
        this.constellationName = constellationName;
        this.alphaStarName = alphaStarName;
        this.numberOfStars = numberOfStars;
        this.starCuriousDTOList = starCuriousDTOList;
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

    public void setNumberOfStars(int numOfStars) {
        this.numberOfStars = numOfStars;
    }

    public List<StarCuriousDTO> getStarCuriousDTOList() {
        return starCuriousDTOList;
    }

    public void setStarCuriousDTOList(List<StarCuriousDTO> starCuriousDTOList) {
        this.starCuriousDTOList = starCuriousDTOList;
    }
}
