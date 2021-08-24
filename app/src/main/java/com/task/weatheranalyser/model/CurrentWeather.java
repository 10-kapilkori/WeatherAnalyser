package com.task.weatheranalyser.model;

import com.google.gson.annotations.SerializedName;

public class CurrentWeather {
    private static final String TAG = "CurrentWeather";

    @SerializedName("location")
    Location location;
    @SerializedName("current")
    Current current;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }
}
