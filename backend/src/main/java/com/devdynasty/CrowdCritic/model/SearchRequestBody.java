package com.devdynasty.CrowdCritic.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestBody {

    @AllArgsConstructor
    @NoArgsConstructor
    public static class Filters {

        @AllArgsConstructor
        @NoArgsConstructor
        public static class Distance {

            private Double lat;
            private Double lon;
            private Integer km;

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLon() {
                return lon;
            }

            public void setLon(Double lon) {
                this.lon = lon;
            }

            public Integer getKm() {
                return km;
            }

            public void setKm(Integer km) {
                this.km = km;
            }
        }

        private Distance distance;
        private List<String> keywords;
        private List<String> categories;

        public Distance getDistance() {
            return distance;
        }

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public List<String> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }
    }

    private Integer start;
    private Integer count;
    private String text;
    private Filters filters;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }
}
