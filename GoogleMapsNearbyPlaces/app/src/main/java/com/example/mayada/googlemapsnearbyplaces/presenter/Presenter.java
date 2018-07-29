package com.example.mayada.googlemapsnearbyplaces.presenter;

import com.example.mayada.googlemapsnearbyplaces.data.access.layer.NearbyPlacesAPIManager;

/**
 * Created by Mayada on 7/29/2018.
 */

public class Presenter {

    private NearbyPlacesAPIManager nearbyPlacesAPIManager = new NearbyPlacesAPIManager();
    public  void getNearPlaces(String location, String placeType){
        nearbyPlacesAPIManager.getNearPlaces(location,placeType);
    }
}
