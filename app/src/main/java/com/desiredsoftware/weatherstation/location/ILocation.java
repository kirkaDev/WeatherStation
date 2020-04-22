package com.desiredsoftware.weatherstation.location;

public interface ILocation {

    double getLongitude();
    double getLatitude();

    void SetLocation(double latitude, double longitude);
}
