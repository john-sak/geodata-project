package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Prefecture {

    @Id
    private Integer id;

    private String name;

    @ManyToMany
    private List<Region> regions;

    public Prefecture(Integer id, String name, List<Region> regions) {
        this.id = id;
        this.name = name;
        this.regions = regions;
    }

    public Prefecture() {

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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
