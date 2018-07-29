package com.example.mayada.googlemapsnearbyplaces.presenter;

import android.view.View;

import com.example.mayada.googlemapsnearbyplaces.MainActivity;
import com.example.mayada.googlemapsnearbyplaces.data.access.layer.NearbyPlacesAPIManager;
import com.example.mayada.googlemapsnearbyplaces.interfaces.MainActivityInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.NearbyManagerAPIInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.PresenterInterface;

/**
 * Created by Mayada on 7/29/2018.
 */

public class Presenter implements PresenterInterface {

    private NearbyManagerAPIInterface nearbyPlacesAPIManager ;
    private MainActivityInterface mainActivityInterface;

   public Presenter(MainActivityInterface v) {
        mainActivityInterface = v;
        initPresenter();
    }

    void initPresenter()
    {
        nearbyPlacesAPIManager=new NearbyPlacesAPIManager(this);
       // mainActivityInterface.initView();
    }

  //  private MainActivity mainActivity = new MainActivity();
    @Override
    public  void getNearPlaces(String location, String placeType){
        nearbyPlacesAPIManager.getNearPlaces(location,placeType);
    }

@Override
   public  void returnNearbyLocations(double[] lats, double[]lngs){
       mainActivityInterface.drawMarker(lats,lngs);
    }
}
