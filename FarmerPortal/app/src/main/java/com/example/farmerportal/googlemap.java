package com.example.farmerportal;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class googlemap extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mapp;
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);
        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapp=googleMap;
        LatLng Maharashtra=new LatLng(21.246532, 75.878142);

        mapp.addMarker(new MarkerOptions().position(Maharashtra).title("Maharashtra"));
        mapp.moveCamera(CameraUpdateFactory.newLatLng(Maharashtra));

    }
}
