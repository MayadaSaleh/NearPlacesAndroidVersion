package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayada on 7/29/2018.
 */

public class OuterNearPlacesPojo implements Serializable{

   private List<Result> results = new ArrayList<Result>();
    private String status;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
