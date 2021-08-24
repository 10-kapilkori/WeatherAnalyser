package com.task.weatheranalyser.model;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.task.weatheranalyser.*;

public class Weather extends BaseObservable {
    private static final String TAG = "Weather";

    Context context;
    private String location;
    private String time;
    private String text;
    private String temp;
    private String humidity;
    private String wind;
    private String feelsLike;
    private String uv;

    public Weather(Context context) {
        this.context = context;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
        notifyPropertyChanged(BR.temp);
    }

    @Bindable
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
        notifyPropertyChanged(BR.humidity);
    }

    @Bindable
    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
        notifyPropertyChanged(BR.wind);
    }

    @Bindable
    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
        notifyPropertyChanged(BR.feelsLike);
    }

    @Bindable
    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
        notifyPropertyChanged(BR.uv);
    }
}
