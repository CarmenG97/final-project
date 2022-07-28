package com.ironhack.edgeservice.controller.dto;

public class EventDTO {

    private Long id;
    private String eventName;
    private String date;
    private String location;
    private String description;
    private String photo;

    public EventDTO() {
    }

    public EventDTO(Long id, String eventName, String date, String location, String description, String photo) {
        this.id = id;
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.description = description;
        this.photo = photo;
    }

    public EventDTO(String eventName, String date, String location, String description, String photo) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.description = description;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
