package com.example.mayada.googlemapsnearbyplaces.access.control;

/**
 * Created by Mayada on 7/29/2018.
 */

public class RetrofitAPIUtils {



    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/";

    public static RetrofitService getService() {
        return RetrofitCreation.getClient(BASE_URL).create(RetrofitService.class);

    }
}
