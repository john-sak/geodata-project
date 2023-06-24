package com.devdynasty.CrowdCritic.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SearchResponseBody {

    private Integer start;
    private Integer count;
    private Integer total;
    private List<PointOfInterest> data;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<PointOfInterest> getData() {
        return data;
    }

    public void setData(List<PointOfInterest> data) {
        this.data = data;
    }
}
