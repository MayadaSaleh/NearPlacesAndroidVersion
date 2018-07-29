package com.example.mayada.googlemapsnearbyplaces.interfaces;

/**
 * Created by Mayada on 7/29/2018.
 */

public interface PresenterInterface {

      void getNearPlaces(String location, String placeType);
      void returnNearbyLocations(double[] lats, double[]lngs);

    }
