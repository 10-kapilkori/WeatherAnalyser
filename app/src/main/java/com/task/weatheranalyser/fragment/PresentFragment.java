package com.task.weatheranalyser.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.task.weatheranalyser.R;
import com.task.weatheranalyser.activity.MainActivity;
import com.task.weatheranalyser.databinding.FragmentPresentBinding;
import com.task.weatheranalyser.model.Condition;
import com.task.weatheranalyser.model.Weather;
import com.task.weatheranalyser.viewmodel.CurrentViewModel;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PresentFragment extends Fragment {
    //    private static final String TAG = "PresentFragment";
    Context context;
    CurrentViewModel viewModel;
    FragmentPresentBinding binding;
    MainActivity activity;
    Weather weather;

    public PresentFragment(Context context, MainActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_present, container, false);
        weather = new Weather(context);
        Calendar calendar = Calendar.getInstance();
        Format f = new SimpleDateFormat("EEEE");
        String date = f.format(new Date());
        String s = calendar.getTime().toString().substring(4, 11);

        viewModel = new ViewModelProvider(this).get(CurrentViewModel.class);
        viewModel.call();

        viewModel.getLiveData().observe(getViewLifecycleOwner(), currentWeather -> {
            weather.setLocation(currentWeather.getLocation().getName());
            weather.setFeelsLike(currentWeather.getCurrent().getFeelsLike() + "℃");
            weather.setHumidity(currentWeather.getCurrent().getHumidity() + "%");
            weather.setTemp(currentWeather.getCurrent().getTemp());
            weather.setUv(currentWeather.getCurrent().getUv());
            weather.setWind(currentWeather.getCurrent().getWind() + "km/h");
            weather.setText(currentWeather.getCurrent().getCondition().getText());
            weather.setTime(date + " " + s);

            binding.setWeather(weather);
        });

        return binding.getRoot();
    }
}
