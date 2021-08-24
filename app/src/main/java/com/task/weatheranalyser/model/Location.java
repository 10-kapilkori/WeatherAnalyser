package com.task.weatheranalyser.model;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("name")
    String name;
    @SerializedName("region")
    String region;
    @SerializedName("localtime")
    String time;

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getTime() {
        return time;
    }
}
