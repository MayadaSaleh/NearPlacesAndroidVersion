package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.util.List;

/**
 * Created by Mayada on 7/29/2018.
 */

public class OuterNearPlacesPojo {

    private List <InnerPojo> results;
    private List<Object> html_attributions;
    private String status;

    public List<InnerPojo> getResults() {
        return results;
    }

    public void setResults(List<InnerPojo> results) {
        this.results = results;
    }

    public List<Object> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<Object> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
