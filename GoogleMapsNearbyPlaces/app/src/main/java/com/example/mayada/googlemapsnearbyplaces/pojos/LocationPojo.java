package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.io.Serializable;

/**
 * Created by Mayada on 7/29/2018.
 */

public class LocationPojo implements Serializable {

   private double lat;
   private double lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
