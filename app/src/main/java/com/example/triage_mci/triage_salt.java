package com.example.triage_mci;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class triage_salt extends AppCompatActivity implements LocationListener {
    private LocationManager mLocationManager;
    private TextView mTextViewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triage_salt);

        Button location = findViewById(R.id.button);
        mTextViewLocation = findViewById(R.id.location);
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(triage_salt.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Request permission if it has not been granted
            ActivityCompat.requestPermissions(triage_salt.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            // Request location updates
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if location permission is granted
                if (ContextCompat.checkSelfPermission(triage_salt.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Request permission if it has not been granted
                    ActivityCompat.requestPermissions(triage_salt.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                } else {
                    // Get the last known location
                    Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (location != null) {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        double altitude = location.getAltitude();
                        String locationInfo = "Latitude: " + latitude + "\nLongitude: " + longitude + "\nAltitude: " + altitude;
                        mTextViewLocation.setText(locationInfo);
                    } else {
                        // Request location updates
                        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, triage_salt.this);
                        Toast.makeText(triage_salt.this, "Trying to get location, please wait...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        double altitude = location.getAltitude();
        String locationInfo = "Latitude: " + latitude + "\nLongitude: " + longitude + "\nAltitude: " + altitude;
        mTextViewLocation.setText(locationInfo);
        mLocationManager.removeUpdates(this);
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Do nothing
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Do nothing
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Do nothing
    }
}
