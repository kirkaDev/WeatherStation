package com.desiredsoftware.weatherstation.location;

public class CoarseLocation extends Location implements ILocation {

    public CoarseLocation()
    {

    }

    @Override
    public double getLongitude() {
        return super.getLongitude();
    }

    @Override
    public double getLatitude() {
        return super.getLatitude();
    }

    @Override
    public void SetLocation(double latitude, double longitude) {

        setLatitude(latitude);
        setLongitude(longitude);
    }

    @Override
    public void setLatitude(double latitude) {
        super.setLatitude(latitude);
    }

    @Override
    public void setLongitude(double longitude) {
        super.setLongitude(longitude);
    }

}
