package com.example.weatherstation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView_cityName;
    TextView textView_degreesAtNow;

    InfoFromServer infoServer;

    ILocation location;

    LocationManager locManager;

    POJO_Weather pojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_cityName = findViewById(R.id.textView_cityName);
        textView_degreesAtNow = findViewById(R.id.textView_degreesAtNow);

        locManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        location = new CoarseLocation();
        getLastKnownLocation();

        infoServer = new InfoFromServer(location);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart() called");
        showWeatherInfo();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        getLastKnownLocation();
        getLocation();
        //showWeatherInfo();
    }

        LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location loc) {
            Log.i("Заходы в методы", "Зашел в onLocationChanged");
            Log.i("Latitude: ", String.valueOf(loc.getLatitude()));
            Log.i("Longitude: ", String.valueOf(loc.getLongitude()));

            double latitude = loc.getLatitude();
            double longitude = loc.getLongitude();

            location.SetLocation(latitude, longitude);

            Toast.makeText(getApplicationContext(), "lat-long: " + String.valueOf(latitude) + ", " + String.valueOf(longitude), Toast.LENGTH_LONG ).show();


            showWeatherInfo();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void getLocation()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            {
                String[] arrStringPermissions =  {Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(this, arrStringPermissions, 0);
            }

            return;
        }
            locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1800000, 0, locationListener);
    }

    private void getLastKnownLocation()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            {
                String[] arrStringPermissions =  {Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(this, arrStringPermissions, 0);
            }

            return;
        }
        double latitude;
        double longitude;

        Location lastKnownLocation = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        latitude = lastKnownLocation.getLatitude();
        longitude = lastKnownLocation.getLongitude();
        location.SetLocation(latitude,longitude);
    }

    private void showWeatherInfo()
    {
        infoServer = new InfoFromServer(location);

        try {
            pojo = infoServer.WeatherAtNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textView_cityName.setText(pojo.getCityName());
        textView_degreesAtNow.setText(pojo.getTemp()+ "°");
        pojo = null;
    }
}
