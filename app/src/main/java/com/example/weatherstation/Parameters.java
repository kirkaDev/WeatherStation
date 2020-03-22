package com.example.weatherstation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Parameters {

    @SerializedName("data")
    @Expose
    public List<POJO_Weather> data = null;
    @SerializedName("count")
    @Expose
    public Integer count;

}


