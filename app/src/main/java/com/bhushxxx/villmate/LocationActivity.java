package com.bhushxxx.villmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_LOCATION = 1;



    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Button location_set_button = findViewById(R.id.location_set_button);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        location_set_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch_location();



            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocationActivity.this , MainActivity.class);


                startActivity(intent);

            }
        });





    }




    private void fetch_location() {

        // Here, thisActivity is the current activity
        // Permission has already been granted
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {



                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object

                            final double longitude = location.getLongitude();
                            final double latitude = location.getLatitude();

                            TextView location_set_text = findViewById(R.id.location_set_text);
                            TextView lat_long_set_text = findViewById(R.id.lat_long_set_text);



                            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                            List<Address> addresses;

                            try {
                                addresses = geocoder.getFromLocation(latitude, longitude,1);

                                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                                String city = addresses.get(0).getLocality();
                                String state = addresses.get(0).getAdminArea();
                                String country = addresses.get(0).getCountryName();
                                String postalCode = addresses.get(0).getPostalCode();
                                String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                                String total_address = address + city + state + country + postalCode + knownName ;

                                lat_long_set_text.setText("longitude : " + longitude + "\nlatitude : " + latitude);
                                location_set_text.setText(total_address);

                                Button button = findViewById(R.id.button);
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(LocationActivity.this , MainActivity.class);
                                        intent.putExtra("lat" , latitude).putExtra("long" , longitude);

                                        startActivity(intent);

                                    }
                                });



                            } catch (IOException e) {
                                e.printStackTrace();
                            }






                        }
                    }




                });




    }
















}
