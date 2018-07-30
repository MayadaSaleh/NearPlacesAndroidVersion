package com.example.mayada.googlemapsnearbyplaces.presenter;

import android.util.Log;
import android.view.View;

import com.example.mayada.googlemapsnearbyplaces.MainActivity;
import com.example.mayada.googlemapsnearbyplaces.data.access.layer.NearbyPlacesAPIManager;
import com.example.mayada.googlemapsnearbyplaces.interfaces.MainActivityInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.NearbyManagerAPIInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.PresenterInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.RouteActivityInterface;

/**
 * Created by Mayada on 7/29/2018.
 */

public class Presenter implements PresenterInterface {

    private NearbyManagerAPIInterface nearbyPlacesAPIManager ;
    private MainActivityInterface mainActivityInterface;
    private RouteActivityInterface routeActivityInterface;


   public Presenter(MainActivityInterface v) {
        mainActivityInterface = v;
        initPresenter();
    }

    public Presenter(RouteActivityInterface v) {
        routeActivityInterface = v;
        initPresenter();
    }

    void initPresenter()
    {
        nearbyPlacesAPIManager=new NearbyPlacesAPIManager(this);
    }

    @Override
    public  void getNearPlaces(String location, String placeType){
        nearbyPlacesAPIManager.getNearPlaces(location,placeType);
    }

    @Override
   public  void returnNearbyLocations(double[] lats, double[]lngs){
       mainActivityInterface.drawMarker(lats,lngs);
    }

    @Override
    public void sendLocation(String origin, String destination) {
        Log.i("ffffff",destination);
        nearbyPlacesAPIManager.getPoints(origin,destination);
    }

    @Override
    public void returnDirectionPoints(String points) {
        routeActivityInterface.drawPolyline(points);
    }
}
