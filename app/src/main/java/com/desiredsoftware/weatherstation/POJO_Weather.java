package com.desiredsoftware.weatherstation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class POJO_Weather {

    @SerializedName("rh")
    @Expose
    public Double rh;
    @SerializedName("pod")
    @Expose
    public String pod;
    @SerializedName("lon")
    @Expose
    public Double lon;
    @SerializedName("pres")
    @Expose
    public Double pres;
    @SerializedName("timezone")
    @Expose
    public String timezone;
    @SerializedName("ob_time")
    @Expose
    public String obTime;
    @SerializedName("country_code")
    @Expose
    public String countryCode;
    @SerializedName("clouds")
    @Expose
    public Double clouds;
    @SerializedName("ts")
    @Expose
    public Double ts;
    @SerializedName("solar_rad")
    @Expose
    public Double solarRad;
    @SerializedName("state_code")
    @Expose
    public String stateCode;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("wind_spd")
    @Expose
    public Double windSpd;
    @SerializedName("last_ob_time")
    @Expose
    public String lastObTime;
    @SerializedName("wind_cdir_full")
    @Expose
    public String windCdirFull;
    @SerializedName("wind_cdir")
    @Expose
    public String windCdir;
    @SerializedName("slp")
    @Expose
    public Double slp;
    @SerializedName("vis")
    @Expose
    public Double vis;
    @SerializedName("h_angle")
    @Expose
    public Double hAngle;
    @SerializedName("sunset")
    @Expose
    public String sunset;
    @SerializedName("dni")
    @Expose
    public Double dni;
    @SerializedName("dewpt")
    @Expose
    public Double dewpt;
    @SerializedName("snow")
    @Expose
    public Double snow;
    @SerializedName("uv")
    @Expose
    public Double uv;
    @SerializedName("precip")
    @Expose
    public Double precip;
    @SerializedName("wind_dir")
    @Expose
    public Double windDir;
    @SerializedName("sunrise")
    @Expose
    public String sunrise;
    @SerializedName("ghi")
    @Expose
    public Double ghi;
    @SerializedName("dhi")
    @Expose
    public Double dhi;
    @SerializedName("aqi")
    @Expose
    public Double aqi;
    @SerializedName("lat")
    @Expose
    public Double lat;
    @SerializedName("weather")
    @Expose
    public Weather weather;
    @SerializedName("datetime")
    @Expose
    public String datetime;

    @SerializedName("temp")
    @Expose
    private Double temp;
    @SerializedName("station")
    @Expose
    public String station;
    @SerializedName("elev_angle")
    @Expose
    public Double elevAngle;
    @SerializedName("app_temp")
    @Expose
    public Double appTemp;

    public String getCityName() {
        return cityName;
    }

    public Double getTemp() {
        return temp;
    }

    public class Weather {

        @SerializedName("icon")
        @Expose
        public String icon;
        @SerializedName("code")
        @Expose
        public String code;
        @SerializedName("description")
        @Expose
        public String description;

    }

}