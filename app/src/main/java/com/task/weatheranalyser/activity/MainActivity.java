package com.task.weatheranalyser.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.task.weatheranalyser.R;
import com.task.weatheranalyser.fragment.PresentFragment;
import com.task.weatheranalyser.fragment.ShareFragment;
import com.task.weatheranalyser.fragment.WeeklyFragment;
import com.task.weatheranalyser.viewmodel.CurrentViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        nav = findViewById(R.id.bottomNav);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new PresentFragment(this, this))
                .commit();

        nav.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.todayMenu:
                    fragment = new PresentFragment(this, this);
                    break;
                case R.id.weekMenu:
                    fragment = new WeeklyFragment(this);
                    break;
                case R.id.shareMenu:
                    fragment = new ShareFragment(this);
                    break;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
            }

            return true;
        });
    }
}