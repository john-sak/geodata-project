package com.devdynasty.CrowdCritic.dto;

import com.devdynasty.CrowdCritic.model.Keyword;
import com.devdynasty.CrowdCritic.model.PointOfInterest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PointOfInterestDTO {

    private Integer id;
    private String name;
    private String description;

    private Integer prefectureID;
    private String prefecture;

    private Integer regionID;
    private String region;

    private List<Integer> keywordsIDs;
    private List<String> keywords;

    private Integer categoryID;
    private String category;

    private Double latitude;
    private Double longitude;

    private String address;

    public PointOfInterestDTO(PointOfInterest poi) {

        this.id = poi.getId();
        this.name = poi.getName();
        this.description = poi.getDescription();

        this.prefectureID = poi.getPrefecture().getId();
        this.prefecture = poi.getPrefecture().getName();

        this.regionID = poi.getPrefecture().getRegions().getId();
        this.region = poi.getPrefecture().getRegions().getName();

        this.keywordsIDs = new ArrayList<Integer>();
        this.keywords = new ArrayList<String>();
        for (Keyword keyword: poi.getKeywords()) {
            this.keywordsIDs.add(keyword.getId());
            this.keywords.add(keyword.getName());
        }

        this.categoryID = poi.getCategories().getId();
        this.category = poi.getCategories().getName();

        this.latitude = poi.getLatitude();
        this.longitude = poi.getLongitude();

        this.address = poi.getAddress();
    }
}
