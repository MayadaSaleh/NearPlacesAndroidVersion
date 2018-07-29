package com.example.mayada.googlemapsnearbyplaces.data.access.layer;

import android.util.Log;

import com.example.mayada.googlemapsnearbyplaces.access.control.RetrofitAPIUtils;
import com.example.mayada.googlemapsnearbyplaces.pojos.OuterNearPlacesPojo;
import com.example.mayada.googlemapsnearbyplaces.pojos.Result;

import java.util.ArrayList;
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
              Log.i("memooooooo",""+outerNearPlacesPojo.getResults().get(0));

                    lats= new double[outerNearPlacesPojo.getResults().size()];
                    lngs= new double[outerNearPlacesPojo.getResults().size()];
                for(int i=0; i< outerNearPlacesPojo.getResults().size();i++){
                    lats[i]= outerNearPlacesPojo.getResults().get(i).getGeometry().getLocation().getLat();
                    lngs[i]= outerNearPlacesPojo.getResults().get(i).getGeometry().getLocation().getLng();
                    // Result r = result.get(i);
                }

                    Log.i("memooooo","lng 2"+lngs[2]);
               // myInteractor.recieveResponseInteractor(returnResponseStatus);
            }

            @Override
            public void onFailure(Call<OuterNearPlacesPojo> call, Throwable t) {
                Log.i("failure",t.getMessage());

               // myInteractor.recieveResponseInteractor(returnResponseStatus);
            }
        });

    }
}
