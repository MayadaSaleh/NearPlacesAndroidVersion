package com.example.mayada.googlemapsnearbyplaces;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mayada.googlemapsnearbyplaces.interfaces.MainActivityInterface;
import com.example.mayada.googlemapsnearbyplaces.interfaces.PresenterInterface;
import com.example.mayada.googlemapsnearbyplaces.presenter.Presenter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, MainActivityInterface,GoogleMap.OnMarkerClickListener {

       private GoogleMap myMap;
       private LocationManager myLocationManager;
       private AlertDialog alertDialog;
       private Double currentLatitude;
       private Double currentLongitude;
       private String fulladdress;
       private PresenterInterface presenterInterface;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},0);
        }
         myLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);




        presenterInterface = new Presenter(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        getCurrentLocation();

        // myLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //getCurrentLocation();
    }

    @OnClick(R.id.mosqueButton)
     void mosqueClicked(View view){
        if(currentLatitude != null && currentLongitude != null){
            String location= currentLatitude+","+currentLongitude;
            presenterInterface.getNearPlaces(location,"Mosque");
        }
    }

    @OnClick(R.id.bankButton)
    void bankClicked(View view){
        if(currentLatitude != null && currentLongitude != null){
            String location= currentLatitude+","+currentLongitude;
            presenterInterface.getNearPlaces(location,"Bank");
        }
    }

    @OnClick(R.id.currentAddress)
    void getCurrentAddress(){
        if(fulladdress != null) {
            Toast.makeText(MainActivity.this, "Current Location is " + fulladdress, Toast.LENGTH_LONG).show();
        }
     }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getCurrentLocation() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(getApplicationContext().getResources().getString(R.string.Failed));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();


            return;
        }else {
            myLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new android.location.LocationListener() {
                        @Override
                        public void onLocationChanged(final Location location) {

                           currentLatitude =  location.getLatitude();
                           currentLongitude = location.getLongitude();
                            //Draw Marker
                            LatLng gps = new LatLng(location.getLatitude(), location.getLongitude());
                            myMap.clear();
                            myMap.addMarker(new MarkerOptions()
                                    .position(gps)
                                    .title("Current Position"));
                            myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gps, 14));


                            // String current Location
                            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                            List<Address> addresses = null;
                            try {
                                // In this sample, get just a single address.
                                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                                String address=addresses.get(0).getAddressLine(0);
                                String area=addresses.get(0).getLocality();
                                String city=addresses.get(0).getAdminArea();
                                String country=addresses.get(0).getCountryName();

                                fulladdress=address+", "+area+", "+city+", "+country;

                            } catch (IOException ioException) {
                                // Catch network or other I/O problems.
                                Log.e("err", "Errorrrr", ioException);
                            } catch (IllegalArgumentException illegalArgumentException) {
                                Log.e("err","errorrrrIllegalArguments", illegalArgumentException);
                            }

                        }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {
                }
                @Override
                public void onProviderEnabled(String s) {
                }
                @Override
                public void onProviderDisabled(String s) {
                }
            });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;
        myMap.setOnMarkerClickListener(this);
    }

@Override
    public void drawMarker(double[] lats, double[]lngs)
    {
        myMap.clear();
        myMap.addMarker(new MarkerOptions().position(new LatLng(currentLatitude,currentLongitude)).title("currentPosition"));
        if(lats != null && lngs != null){
           for(int i=0; i< lats.length;i++){
               LatLng position = new LatLng(lats[i], lngs[i]);
               myMap.addMarker(new MarkerOptions()
                       .position(position)
                       .title("Nearby"));
               myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 14));

           }
        }else {
            Toast.makeText(MainActivity.this,"Error in loading near by places",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onMarkerClick(final Marker marker) {

        Intent intent = new Intent(MainActivity.this,RouteActivity.class);
        intent.putExtra("currentlat",currentLatitude);
        intent.putExtra("currentlng",currentLongitude);
        intent.putExtra("destinationlat",marker.getPosition().latitude);
        intent.putExtra("destinationlng",marker.getPosition().longitude);
        startActivity(intent);

        return false;
    }
}
