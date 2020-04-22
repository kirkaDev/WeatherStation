package com.desiredsoftware.weatherstation.weatherapi;

import com.desiredsoftware.weatherstation.Parameters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWeatherApiWeatherbit extends IWeatherApi {

    @GET("v2.0/current?")
    Call<Parameters> GetWeatherByLocation(@Query("lat") double latitude, @Query("lon") double longitude, @Query("key") String API_Key);
}
