package com.example.amateurproxyservice.model;

import javax.persistence.*;


@Entity
public class Amateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int yearsOfExperience;
    private String password;
    private String photo;

    public Amateur() {
    }

    public Amateur(Long id, String name, String email, int yearsOfExperience, String password, String photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.password = password;
        this.photo = photo;
    }

    public Amateur(String name, String email, int yearsOfExperience, String password, String photo) {
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
