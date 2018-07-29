package com.example.mayada.googlemapsnearbyplaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RouteActivity extends FragmentActivity implements OnMapReadyCallback{


    GoogleMap routingMap;
    Double currentLat;
    Double currentLng;
    Double destinationlat;
    Double destinationlng;

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

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        routingMap = googleMap;
        addMarkers();
    }

    private void addMarkers(){
        LatLng position = new LatLng(currentLat,currentLng);
        routingMap.addMarker(new MarkerOptions()
                .position(position)
                .title("CurrentLocation"));
        routingMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 14));

        LatLng desiredposition = new LatLng(destinationlat,destinationlng);
        routingMap.addMarker(new MarkerOptions()
                .position(desiredposition)
                .title("Destination"));
        routingMap.animateCamera(CameraUpdateFactory.newLatLngZoom(desiredposition, 14));
    }
}
