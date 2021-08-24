package com.task.weatheranalyser.instance;

import com.task.weatheranalyser.model.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("v1/current.json")
    Call<CurrentWeather> currentWeather(
            @Query("key") String key,
            @Query("q") String q
    );
}
