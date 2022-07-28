package com.example.amateurproxyservice.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Relations
    @ManyToOne
    private Amateur amateur;

    public Role() {
    }

    public Role(Long id, String name, Amateur amateur) {
        this.id = id;
        this.name = name;
        this.amateur = amateur;
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

    public Amateur getAmateur() {
        return amateur;
    }

    public void setAmateur(Amateur amateur) {
        this.amateur = amateur;
    }
}
