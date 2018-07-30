package com.example.mayada.googlemapsnearbyplaces.access.control;

/**
 * Created by Mayada on 7/29/2018.
 */

public class RetrofitAPIUtils {



    public static final String BASE_URL_NearPlaces = "https://maps.googleapis.com/maps/api/place/nearbysearch/";
    public static final String BASE_URL_Direction_Points = "https://maps.googleapis.com/maps/api/directions/";

    public static RetrofitService getNearPlacesService() {
        return RetrofitCreation.getClient(BASE_URL_NearPlaces).create(RetrofitService.class);

    }

    public static RetrofitService getPointsService() {
        return RetrofitCreation.getClient(BASE_URL_Direction_Points).create(RetrofitService.class);

    }
}
