package com.task.weatheranalyser.model;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("temp_c")
    String temp;
    @SerializedName("condition")
    Condition condition;
    @SerializedName("wind_kph")
    String wind;
    @SerializedName("humidity")
    String humidity;
    @SerializedName("feelslike_c")
    String feelsLike;
    @SerializedName("uv")
    String uv;

    public String getTemp() {
        return temp;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getWind() {
        return wind;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getUv() {
        return uv;
    }
}
