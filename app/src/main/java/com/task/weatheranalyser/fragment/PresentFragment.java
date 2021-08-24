package com.task.weatheranalyser.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.task.weatheranalyser.R;
import com.task.weatheranalyser.databinding.FragmentPresentBinding;
import com.task.weatheranalyser.viewmodel.CurrentViewModel;

public class PresentFragment extends Fragment {
    Context context;
    CurrentViewModel viewModel;
    FragmentPresentBinding binding;

    public PresentFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_present, container, false);

        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_present);
        viewModel = new ViewModelProvider(this).get(CurrentViewModel.class);
        viewModel.call();

        return view;
    }
}