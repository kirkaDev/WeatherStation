# WeatherStation
It's a pocket weather station that provides data from more than 45,000 physical weather stations (34 countries)

This is a native Android application developed using the Java language.

### Where does the application receive data? 
The application uses a third-party API to receive data from physical weather stations.

To work with this API, just register and get a API Key (free or by subscription).

The free API Key allows you to perform 500 requests per day, allows you to get current weather data, as well as a forecast for 16 days in advance

API documentation can be found here: https://www.weatherbit.io/api

### Data processing
The application uses the [Retrofit2](https://github.com/square/retrofit) library for server requests and data processing.
Retrofit receives a JSON-file from the server and creates [POJO](https://en.wikipedia.org/wiki/Plain_old_Java_object) for further work with data.



