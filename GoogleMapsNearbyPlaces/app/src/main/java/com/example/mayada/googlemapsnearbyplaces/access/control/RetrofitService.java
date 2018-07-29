package com.example.mayada.googlemapsnearbyplaces.access.control;

import com.example.mayada.googlemapsnearbyplaces.pojos.OuterNearPlacesPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mayada on 7/29/2018.
 */

public interface RetrofitService {

    @GET("json?radius=5000&keyword=cruise&key=AIzaSyAyvwsWwM6Nuo9zC69q-TG4o-nl8uJhGHI")
    @Headers({"Accept: application/json","Content-Type: application/json"})
    Call<OuterNearPlacesPojo> getNearbyPlaces (@Query ("location") String location,
                                               @Query("type") String type);

}
