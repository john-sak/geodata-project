package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class PointOfInterest {

    @Id
    private Integer id;

    private String name;

    private String description;

    @ManyToOne
    private Prefecture prefecture;

    @ManyToMany
    private List<Keyword> keywords;

    @ManyToMany
    private List<Category> categories;

    private Double latitude;

    private Double longitude;

    public PointOfInterest(Integer id, String name, String description, Prefecture prefecture, List<Keyword> keywords, List<Category> categories, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prefecture = prefecture;
        this.keywords = keywords;
        this.categories = categories;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PointOfInterest() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Prefecture getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(Prefecture prefecture) {
        this.prefecture = prefecture;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
