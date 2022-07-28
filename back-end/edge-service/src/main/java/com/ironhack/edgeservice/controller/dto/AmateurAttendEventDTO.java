package com.ironhack.edgeservice.controller.dto;

public class AmateurAttendEventDTO {

    private Long id;
    private long amateurId;
    private long eventId;

    public AmateurAttendEventDTO() {
    }

    public AmateurAttendEventDTO(long amateurId, long eventId) {
        this.amateurId = amateurId;
        this.eventId = eventId;
    }

    public void setAmateurId(long amateurId) {
        this.amateurId = amateurId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
}
