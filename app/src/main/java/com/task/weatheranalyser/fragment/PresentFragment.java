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
    private static final String TAG = "PresentFragment";

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
            float temp = currentWeather.getCurrent().getTemp();
            float feelsLike = currentWeather.getCurrent().getFeelsLike();
            float wind = currentWeather.getCurrent().getWind();
            float uv = currentWeather.getCurrent().getUv();
            String type = currentWeather.getCurrent().getCondition().getText();

            weather.setLocation(currentWeather.getLocation().getName());
            weather.setFeelsLike((int) feelsLike + "℃");
            weather.setHumidity(currentWeather.getCurrent().getHumidity() + "%");
            weather.setTemp((int) temp + "");
            weather.setUv((int) uv + "");
            weather.setWind((int) wind + "km/h");
            weather.setText(currentWeather.getCurrent().getCondition().getText());
            weather.setTime(date + " " + s);

            if (type.contains("Sunny")) {
                Glide.with(context)
                        .load(R.drawable.ic_sun)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_1)
                        .into(binding.weatherIv);
            } else if (type.contains("Partly cloudy")) {
                Glide.with(context)
                        .load(R.drawable.ic_cloudy)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_2)
                        .into(binding.weatherIv);
            } else if (type.contains("Cloudy")) {
                Glide.with(context)
                        .load(R.drawable.ic_cloudy_weather)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_2)
                        .into(binding.weatherIv);
            } else if (type.contains("Overcast")) {
                Glide.with(context)
                        .load(R.drawable.ic_overcast)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_2)
                        .into(binding.weatherIv);
            } else if (type.contains("Mist")) {
                Glide.with(context)
                        .load(R.drawable.ic_mist)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_3)
                        .into(binding.weatherIv);
            } else if (type.contains("rain")) {
                Glide.with(context)
                        .load(R.drawable.ic_rain)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_2)
                        .into(binding.weatherIv);
            } else if (type.contains("snow")) {
                Glide.with(context)
                        .load(R.drawable.ic_snow)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_3)
                        .into(binding.weatherIv);
            } else if (type.contains("Blizzard")) {
                Glide.with(context)
                        .load(R.drawable.ic_blizzard)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_3)
                        .into(binding.weatherIv);
            } else if (type.contains("sleet")) {
                Glide.with(context)
                        .load(R.drawable.ic_sleet)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_3)
                        .into(binding.weatherIv);
            } else if (type.contains("fog")) {
                Glide.with(context)
                        .load(R.drawable.ic_foggy)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_3)
                        .into(binding.weatherIv);
            } else if (type.contains("heavy rain")) {
                Glide.with(context)
                        .load(R.drawable.ic_heavy_rain)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_2)
                        .into(binding.weatherIv);
            } else if (type.contains("light rain")) {
                Glide.with(context)
                        .load(R.drawable.ic_light_rain)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_2)
                        .into(binding.weatherIv);
            } else if (type.contains("thunder")) {
                Glide.with(context)
                        .load(R.drawable.ic_thunder_storm)
                        .into(binding.weatherTypeIv);
                Glide.with(context)
                        .load(R.drawable.ic_frame_2)
                        .into(binding.weatherIv);
            }

            binding.setWeather(weather);
        });

        return binding.getRoot();
    }
}
