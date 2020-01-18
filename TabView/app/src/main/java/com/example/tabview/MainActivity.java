package com.example.tabview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);

        viewPager.setAdapter(adapter);

        tablayout = findViewById(R.id.tabs);

        tablayout.setupWithViewPager(viewPager);

    }
}
