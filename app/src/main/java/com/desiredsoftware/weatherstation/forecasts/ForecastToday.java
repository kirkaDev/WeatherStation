package com.desiredsoftware.weatherstation.forecasts;

import com.desiredsoftware.weatherstation.location.ILocation;
import com.desiredsoftware.weatherstation.Weather;
import com.desiredsoftware.weatherstation.weatherapi.IWeatherApi;

public class ForecastToday extends Forecast {

    private ILocation mLocation;
    private IWeatherApi mWeatherApi;

    private String mCityName;

    private Weather mWeatherAtNow;
    private Weather mWeatherMorning;
    private Weather mWeatherAfternoon;
    private Weather mWeatherEvening;
    private Weather mWeatherNight;

}
