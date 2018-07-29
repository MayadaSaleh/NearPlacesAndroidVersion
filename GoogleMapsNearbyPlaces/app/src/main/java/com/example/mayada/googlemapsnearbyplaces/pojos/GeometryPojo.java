package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.io.Serializable;

/**
 * Created by Mayada on 7/29/2018.
 */

public class GeometryPojo implements Serializable{
    private LocationPojo location;

    public LocationPojo getLocation() {
        return location;
    }

    public void setLocation(LocationPojo location) {
        this.location = location;
    }
}
