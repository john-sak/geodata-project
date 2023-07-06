package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.*;

@Entity
public class Prefecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private Region region;

    public Prefecture(Integer id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public Prefecture() {

    }

    public Prefecture(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegions() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
