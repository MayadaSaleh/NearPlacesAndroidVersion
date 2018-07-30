package com.example.mayada.googlemapsnearbyplaces.interfaces;

/**
 * Created by Mayada on 7/29/2018.
 */

public interface NearbyManagerAPIInterface {

     void getNearPlaces(String location, String placeType);

    void getPoints(String origin, String destination);
}
