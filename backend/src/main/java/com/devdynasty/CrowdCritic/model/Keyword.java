package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.*;

@Entity
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "word")
    private String name;

    public Keyword(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Keyword() {

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

    public void setName(String word) {
        this.name = word;
    }
}
