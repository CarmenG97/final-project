package com.ironhack.edgeservice.controller.dto;


import java.util.Set;


public class AmateurDTO {
    private Long id;
    private String name;
    private String email;
    private int yearsOfExperience;
    private String password;
    private String photo;

//    private Set<RoleDTO> roles;

    public AmateurDTO() {
    }

    public AmateurDTO(Long id, String name, String email, int yearsOfExperience, String password, String photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.password = password;
        this.photo = photo;
    }

    public AmateurDTO(String name, String email, int yearsOfExperience, String password, String photo) {
        this.name = name;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.password = password;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
