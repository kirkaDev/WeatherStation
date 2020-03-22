package com.example.weatherstation;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRESTful {

    //Call<Parameters> GetWeather();
    @GET("https://api.weatherbit.io/v2.0/current?lat=56.425&lon=61.9222&lang=ru&key=1a75353c54ed4ae7a4a948fccc0b82ef")
    Call<Parameters> GetWeatherByLocation();


}
