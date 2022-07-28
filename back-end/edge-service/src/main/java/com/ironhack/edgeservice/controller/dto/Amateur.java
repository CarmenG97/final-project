package com.ironhack.edgeservice.controller.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class Amateur implements UserDetails {

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
//        this.roles = roles;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));


        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
