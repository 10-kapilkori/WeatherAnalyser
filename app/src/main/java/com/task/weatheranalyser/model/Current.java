package com.task.weatheranalyser.model;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("temp_c")
    float temp;
    @SerializedName("condition")
    Condition condition;
    @SerializedName("wind_kph")
    float wind;
    @SerializedName("humidity")
    String humidity;
    @SerializedName("feelslike_c")
    float feelsLike;
    @SerializedName("uv")
    float uv;

    public float getTemp() {
        return temp;
    }

    public Condition getCondition() {
        return condition;
    }

    public float getWind() {
        return wind;
    }

    public String getHumidity() {
        return humidity;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public float getUv() {
        return uv;
    }
}
