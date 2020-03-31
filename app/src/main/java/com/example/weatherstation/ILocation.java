package com.example.weatherstation;

public interface ILocation {

    double getLongitude();
    double getLatitude();

    void SetLocation(double latitude, double longitude);
}
