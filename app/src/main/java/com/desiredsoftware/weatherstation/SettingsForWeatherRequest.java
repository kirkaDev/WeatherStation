package com.desiredsoftware.weatherstation;

import com.desiredsoftware.weatherstation.forecasts.ForecastToday;
import com.desiredsoftware.weatherstation.location.ILocation;
import com.desiredsoftware.weatherstation.weatherapi.IWeatherApi;

public class SettingsForWeatherRequest {

    private ILocation mLocation;
    private Class<IWeatherApi> mWeatherApi;

    public static class Builder
    {
        SettingsForWeatherRequest settingsForWeatherRequest;

        Builder(){
            settingsForWeatherRequest = new SettingsForWeatherRequest();
        }

        public Builder withLocationType(ILocation location)
        {
            settingsForWeatherRequest.mLocation = location;
            return this;
        }

        public Builder withWeatherApi(Class<IWeatherApi> weatherApi)
        {
            settingsForWeatherRequest.mWeatherApi = weatherApi;
            return this;
        }

        public SettingsForWeatherRequest build()
        {
            return settingsForWeatherRequest;
        }
    }
}
