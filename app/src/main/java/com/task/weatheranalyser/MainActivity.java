package com.task.weatheranalyser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.bottomNav);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new PresentFragment())
                .commit();

        nav.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.todayMenu:
                    fragment = new PresentFragment();
                    break;
                case R.id.weekMenu:
                    fragment = new WeeklyFragment();
                    break;
                case R.id.shareMenu:
                    fragment = new ShareFragment();
                    break;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
            }

            return true;
        });
    }
}