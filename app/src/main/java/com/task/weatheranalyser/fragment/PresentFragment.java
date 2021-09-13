package com.task.weatheranalyser.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.task.weatheranalyser.R;
import com.task.weatheranalyser.activity.MainActivity;
import com.task.weatheranalyser.databinding.FragmentPresentBinding;
import com.task.weatheranalyser.viewmodel.CurrentViewModel;

public class PresentFragment extends Fragment {
    Context context;
    CurrentViewModel viewModel;
    FragmentPresentBinding binding;
    MainActivity activity;

    public PresentFragment(Context context, MainActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_present, container, false);

        viewModel = new ViewModelProvider(this).get(CurrentViewModel.class);
        viewModel.call();

        return binding.getRoot();
    }
}