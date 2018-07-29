package com.example.mayada.googlemapsnearbyplaces.data.access.layer;

import android.util.Log;

import com.example.mayada.googlemapsnearbyplaces.access.control.RetrofitAPIUtils;
import com.example.mayada.googlemapsnearbyplaces.pojos.OuterNearPlacesPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mayada on 7/29/2018.
 */

public class NearbyPlacesAPIManager {

    double[] lats;
    double[]lngs;
    public void getNearPlaces(String location, String placeType) {
        Call<OuterNearPlacesPojo> responseCall = RetrofitAPIUtils.getService().getNearbyPlaces(location,placeType);
        responseCall.enqueue(new Callback<OuterNearPlacesPojo>() {

            @Override
            public void onResponse(Call<OuterNearPlacesPojo> call, Response<OuterNearPlacesPojo> response) {
                OuterNearPlacesPojo outerNearPlacesPojo = response.body();
                Log.i("memooooooo",""+outerNearPlacesPojo.getResults().get(0).getGeometry().get(0).getLocation().getLat());
                Log.i("memooooooo",""+outerNearPlacesPojo.getResults().get(0).getGeometry().get(0).getLocation().getLng());

                for(int i=0; i< outerNearPlacesPojo.getResults().get(0).getGeometry().size();i++){
                    lats[i]= outerNearPlacesPojo.getResults().get(0).getGeometry().get(i).getLocation().getLat();
                    lngs[i]= outerNearPlacesPojo.getResults().get(0).getGeometry().get(0).getLocation().getLng();
                }


               // myInteractor.recieveResponseInteractor(returnResponseStatus);
            }

            @Override
            public void onFailure(Call<OuterNearPlacesPojo> call, Throwable t) {
                Log.i("memooooooo","faaaaaaaaaaaaaaaaaail");
                Log.i("failure",t.getMessage());

               // myInteractor.recieveResponseInteractor(returnResponseStatus);
            }
        });

    }
}
