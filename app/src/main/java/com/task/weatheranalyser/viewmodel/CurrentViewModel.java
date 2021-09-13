package com.task.weatheranalyser.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.task.weatheranalyser.instance.API;
import com.task.weatheranalyser.instance.RetrofitInstance;
import com.task.weatheranalyser.model.CurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentViewModel extends ViewModel {
    private static final String TAG = "CurrentViewModel";

    private final MutableLiveData<CurrentWeather> liveData;
    private final MutableLiveData<String> errorLiveData;

    public CurrentViewModel() {
        liveData = new MutableLiveData<>();
        errorLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<CurrentWeather> getLiveData() {
        return liveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void call() {
        API api = new RetrofitInstance().getInstance().create(API.class);
        Call<CurrentWeather> call = api.currentWeather("417e156b1b7a484d933185027212408",
                "indore");

        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeather> call, @NonNull Response<CurrentWeather> response) {
                if (response.body() != null) {
                    CurrentWeather s = response.body();
                    liveData.postValue(s);
                    Log.i(TAG, "onResponse: " + response.body().getCurrent().getCondition().getText());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeather> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                errorLiveData.postValue(t.getMessage());
            }
        });
    }
}
