package com.exemple.android.miwoklanguageeducation;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    //TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    TabLayout tablayout;
    TabItem numbers;
    TabItem family;
    TabItem colors;
    TabItem phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        tablayout = findViewById(R.id.tablayout);
        numbers  = findViewById(R.id.numbers);
        family = findViewById(R.id.family);
        colors = findViewById(R.id.colors);
        phrases = findViewById(R.id.phrases);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
    }
