package com.devdynasty.CrowdCritic.model;

import com.devdynasty.CrowdCritic.dto.PointOfInterestDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SearchResponseBody {

    private Integer start;
    private Integer count;
    private Integer total;
    private List<PointOfInterestDTO> data;

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

    public List<PointOfInterestDTO> getData() {
        return data;
    }

    public void setData(List<PointOfInterestDTO> data) {
        this.data = data;
    }
}
