package com.example.mayada.googlemapsnearbyplaces.access.control;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mayada on 7/29/2018.
 */

public class RetrofitCreation {

    public static Retrofit getClient(String baseUrl) {
        Retrofit retrofit = null;
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
