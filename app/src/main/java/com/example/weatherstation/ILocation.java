package com.example.weatherstation;

public interface ILocation {

    //public Location GetLocation();

    double getLongitude();
    double getLatitude();

    void SetLocation(double latitude, double longitude);
}
