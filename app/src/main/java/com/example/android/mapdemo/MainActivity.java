package com.example.android.mapdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.Manifest;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    MapView mapView;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        showCameraPreview();
    }
        @Override
        public void onMapReady(GoogleMap googleMap) {
            map = googleMap;
            map.getUiSettings().setMyLocationButtonEnabled(false);
            map.setMyLocationEnabled(true);
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(17.361633, 78.474659))
                    .title("Charminar"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(17.361633, 78.474659), 15));
//            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(37.4233438, -122.0728817)));

        }

        @Override
        public void onResume() {
            mapView.onResume();
            super.onResume();
        }


        @Override
        public void onPause() {
            super.onPause();
            mapView.onPause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mapView.onDestroy();
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mapView.onLowMemory();
        }

    private void showCameraPreview() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(this, new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION },
                    1);
        }
    }

    }
