package com.example.weatherstation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    Button pullMsgToServerBtn;
    Button btnGetLocation;

    EditText editTextLatitude;
    EditText editTextLongitude;

    TextView txtView_cityName;
    TextView recievedFromServerTextView;

    InfoFromServer infoServer;

    ILocation location;

    LocationManager locManager;

    POJO_Weather pojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoServer = new InfoFromServer();

        locManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        location = new CoarseLocation();

        editTextLatitude = findViewById(R.id.editTextLatitude);
        editTextLongitude = findViewById(R.id.editTextLongitude);

        pullMsgToServerBtn = findViewById(R.id.button_get_weather);
        btnGetLocation = findViewById(R.id.btnGetLocation);
        recievedFromServerTextView = findViewById(R.id.recievedText);
        txtView_cityName = findViewById(R.id.txtView_cityName);

        // "Show the weather"
        pullMsgToServerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {

                pojo = null;
                getLocation();
                infoServer = new InfoFromServer(location);

                try {
                    pojo = infoServer.WeatherAtNow();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                txtView_cityName.setText(pojo.getCityName());
                recievedFromServerTextView.setText(getString(R.string.msgTempOverboard) + pojo.getTemp()+ "\n");
            }
        });

        // Получение координат при нажатии на кнопку "GPS"
        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
                showLocation();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart() called");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getLocation();
    }

        LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location loc) {
            Log.i("Заходы в методы", "Зашел в onLocationChanged");
            Log.i("Latitude: ", String.valueOf(loc.getLatitude()));
            Log.i("Longitude: ", String.valueOf(loc.getAltitude()));

            double latitude = loc.getLatitude();
            double longitude = loc.getLongitude();

            location.SetLocation(latitude, longitude);
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

        locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 1, locationListener);
    }

    private void showLocation()
    {
        editTextLatitude.setText(String.valueOf(location.getLatitude()));
        editTextLongitude.setText(String.valueOf(location.getLongitude()));
    }

}
