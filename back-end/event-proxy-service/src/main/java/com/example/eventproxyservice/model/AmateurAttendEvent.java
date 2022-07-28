package com.example.eventproxyservice.model;

import javax.persistence.*;

@Entity
public class AmateurAttendEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long amateurId;
    private long eventId;

    public AmateurAttendEvent() {
    }

    public AmateurAttendEvent(long id, long amateurId, long eventId) {
        this.id = id;
        this.amateurId = amateurId;
        this.eventId = eventId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmateurId() {
        return amateurId;
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
