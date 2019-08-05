package com.bhushxxx.villmate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, AccountFragment.OnFragmentInteractionListener, NearbyShopsMapFragment.OnFragmentInteractionListener {

    private FragmentManager fragmentManager;

    HomeFragment home_fragment = new HomeFragment();
    NearbyShopsMapFragment nearby_shops_fragment = new NearbyShopsMapFragment();
    AccountFragment account_fragment = new AccountFragment();






    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    fragmentTransaction.replace(R.id.fragment_container, home_fragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:

                    fragmentTransaction.replace(R.id.fragment_container, nearby_shops_fragment);
                    fragmentTransaction.commit();


                    return true;
                case R.id.navigation_notifications:


                    fragmentTransaction.replace(R.id.fragment_container, account_fragment);
                    fragmentTransaction.commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);




        /*fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, home_fragment);
        fragmentTransaction.commit();*/










        getData();













        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void checkout_activity(View view) {





        Intent i = new Intent(getApplicationContext(), CheckoutActivity.class);
        startActivity(i);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public double[] getData(){



        double[] location = new double[2];
        Intent intent = getIntent();
        location[0] =intent.getDoubleExtra("lat", 1);
        location[1] =intent.getDoubleExtra("long", 1);




        return location;



    }

}
