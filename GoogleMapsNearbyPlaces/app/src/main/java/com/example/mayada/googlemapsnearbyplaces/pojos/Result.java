package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mayada on 7/29/2018.
 */

public class Result implements Serializable{
    private String name;
    private GeometryPojo geometry;


    public GeometryPojo getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryPojo geometry) {
        this.geometry = geometry;
    }
}
