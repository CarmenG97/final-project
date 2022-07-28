package com.ironhack.constellationproxyservice.controller.dto;

import java.util.List;

public class ConstellationDTO {
    private long id;
    private String constellationName;
    private String alphaStarName;
    private int numberOfStars;
    private String profilePicture;

    // List of stars
    private List<StarDTO> starDTOList;

    private String history;

    public ConstellationDTO() {
    }

    public ConstellationDTO(long id, String constellationName, String alphaStarName, int numberOfStars, List<StarDTO> starDTOList, String profilePicture, String history) {
        this.id = id;
        this.constellationName = constellationName;
        this.alphaStarName = alphaStarName;
        this.numberOfStars = numberOfStars;
        this.starDTOList = starDTOList;
        this.profilePicture = profilePicture;
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
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

    public List<StarDTO> getStarDTOList() {
        return starDTOList;
    }

    public void setStarDTOList(List<StarDTO> starDTOList) {
        this.starDTOList = starDTOList;
    }
}
