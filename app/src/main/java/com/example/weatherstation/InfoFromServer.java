package com.example.weatherstation;

import android.util.Log;

import java.util.Objects;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoFromServer {

    private POJO_Weather pojo_Weather;

    private String API_Key = "1a75353c54ed4ae7a4a948fccc0b82ef";
    private String latitude;
    private String longitude;
    private String requestToServer;

    private ILocation location;

    private boolean threadFinished = false;

    InfoFromServer(ILocation location)
    {
        this.location = location;
        pojo_Weather = new POJO_Weather();

    }

    InfoFromServer()
    {
        pojo_Weather = new POJO_Weather();
    }

    public POJO_Weather WeatherAtNow() throws InterruptedException {

        // do something
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weatherbit.io/")
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService restful = retrofit.create(APIService.class);

        double lat = location.getLatitude();
        double lon = location.getLongitude();

        Call<Parameters> call = restful.GetWeatherByLocation(lat, lon, API_Key);

        call.enqueue(new Callback<Parameters>() {
            @Override
            public void onResponse(Call<Parameters> call, Response<Parameters> response) {

                if(!response.isSuccessful()) {
                    Log.i("It's going wrong", "Code: " + response.code());
                    return;
                }

                Parameters resp = response.body();

                assert resp != null;
                pojo_Weather = resp.data.get(0);

                threadFinished = true;
            }

            @Override
            public void onFailure(Call<Parameters> call, Throwable t) {
                Log.e("InfoFromServer.class", Objects.requireNonNull(t.getMessage()));
            }
        });

            for (int count=0; count < 100; count++ )
        {
            Thread.sleep(100);
            Log.d ("Getting POJO", String.valueOf(count*100));
            if (threadFinished)
            return pojo_Weather;
        }
            if (pojo_Weather == null)
            {
                Log.e("InfoFromServer", "Data from server did not recieved");
            }
        return pojo_Weather;
    }
}
