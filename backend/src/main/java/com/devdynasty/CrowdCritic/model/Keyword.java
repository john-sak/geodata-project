package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Keyword {

    @Id
    private Integer id;

    private String word;

    public Keyword(Integer id, String word) {
        this.id = id;
        this.word = word;
    }

    public Keyword() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
