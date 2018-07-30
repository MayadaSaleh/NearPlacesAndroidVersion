package com.example.mayada.googlemapsnearbyplaces.data.access.layer;

import android.util.Log;

import com.example.mayada.googlemapsnearbyplaces.access.control.RetrofitAPIUtils;
import com.example.mayada.googlemapsnearbyplaces.interfaces.NearbyManagerAPIInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.PresenterInterface;
import com.example.mayada.googlemapsnearbyplaces.pojos.OuterDirectionAPIPojo;
import com.example.mayada.googlemapsnearbyplaces.pojos.OuterNearPlacesPojo;
import com.example.mayada.googlemapsnearbyplaces.pojos.Result;
import com.example.mayada.googlemapsnearbyplaces.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mayada on 7/29/2018.
 */

public class NearbyPlacesAPIManager implements NearbyManagerAPIInterface {

     private double[] lats;
     private double[]lngs;
    private String points;

    PresenterInterface presenter;
    public NearbyPlacesAPIManager (PresenterInterface pres){
    this.presenter=pres;
    }


    @Override
    public void getNearPlaces(String location, String placeType) {
        Call<OuterNearPlacesPojo> responseCall = RetrofitAPIUtils.getNearPlacesService().getNearbyPlaces(location,placeType);
        responseCall.enqueue(new Callback<OuterNearPlacesPojo>() {

            @Override
            public void onResponse(Call<OuterNearPlacesPojo> call, Response<OuterNearPlacesPojo> response) {
               OuterNearPlacesPojo outerNearPlacesPojo = response.body();

                    lats= new double[outerNearPlacesPojo.getResults().size()];
                    lngs= new double[outerNearPlacesPojo.getResults().size()];
                for(int i=0; i< outerNearPlacesPojo.getResults().size();i++){
                    lats[i]= outerNearPlacesPojo.getResults().get(i).getGeometry().getLocation().getLat();
                    lngs[i]= outerNearPlacesPojo.getResults().get(i).getGeometry().getLocation().getLng();
                }
               presenter.returnNearbyLocations(lats,lngs);
            }

            @Override
            public void onFailure(Call<OuterNearPlacesPojo> call, Throwable t) {
                Log.i("failure",t.getMessage());

                presenter.returnNearbyLocations(null,null);
            }
        });
    }

    @Override
    public void getPoints(String origin, String destination) {
        Call<OuterDirectionAPIPojo> responseCall = RetrofitAPIUtils.getPointsService().getDirectionPoints(origin,destination);
        responseCall.enqueue(new Callback<OuterDirectionAPIPojo>() {

            @Override
            public void onResponse(Call<OuterDirectionAPIPojo> call, Response<OuterDirectionAPIPojo> response) {
                OuterDirectionAPIPojo outerDirectionAPIPojo = response.body();

                points= outerDirectionAPIPojo.getRoutes().get(0).getOverview_polyline().getPoints();
               presenter.returnDirectionPoints(points);
            }

            @Override
            public void onFailure(Call<OuterDirectionAPIPojo> call, Throwable t) {
                Log.i("failure",t.getMessage());
                presenter.returnDirectionPoints(points);
            }
        });
    }
}
