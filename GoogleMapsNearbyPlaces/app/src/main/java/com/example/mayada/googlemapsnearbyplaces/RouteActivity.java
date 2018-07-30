package com.example.mayada.googlemapsnearbyplaces;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.mayada.googlemapsnearbyplaces.interfaces.PresenterInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.RouteActivityInterface;
import com.example.mayada.googlemapsnearbyplaces.presenter.Presenter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import java.util.List;
import butterknife.ButterKnife;

public class RouteActivity extends FragmentActivity implements RouteActivityInterface, OnMapReadyCallback{

    GoogleMap routingMap;
    Double currentLat;
    Double currentLng;
    Double destinationlat;
    Double destinationlng;

    PresenterInterface presenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.staticMap);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
         currentLat = intent.getDoubleExtra("currentlat",0);
         currentLng = intent.getDoubleExtra("currentlng",0);
         destinationlat = intent.getDoubleExtra("destinationlat",0);
         destinationlng = intent.getDoubleExtra("destinationlng",0);
      //  presenterInterface = new Presenter(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        routingMap = googleMap;
        addMarkers();
        String origin = currentLat+","+currentLng;
        String destination = destinationlat + "," + destinationlng;
        presenterInterface = new Presenter(RouteActivity.this);
        presenterInterface.sendLocation(origin,destination);
    }

    private void addMarkers(){
        //Origin Marker
        LatLng position = new LatLng(currentLat,currentLng);
        routingMap.addMarker(new MarkerOptions()
                .position(position)
                .title("CurrentLocation"));
        routingMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 14));

        //Destination Marker
        LatLng desiredposition = new LatLng(destinationlat,destinationlng);
        routingMap.addMarker(new MarkerOptions()
                .position(desiredposition)
                .title("Destination"));
        routingMap.animateCamera(CameraUpdateFactory.newLatLngZoom(desiredposition, 14));
    }

    @Override
    public void drawPolyline(String points) {
        List<LatLng> list = PolyUtil.decode(points);
        PolylineOptions options = new PolylineOptions().width(5).color(Color.BLUE).geodesic(true);
        for (int z = 0; z < list.size(); z++) {
            LatLng point = list.get(z);
            options.add(point);
        }
         routingMap.addPolyline(options);
    }
}
