package com.whatsap.statussaver.activity;

import android.app.Activity;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.whatsap.statussaver.R;
import com.whatsap.statussaver.adapter.ViewPagerAdapter;
import com.whatsap.statussaver.fragment.GifsFragment;
import com.whatsap.statussaver.fragment.PhotosFragment;
import com.whatsap.statussaver.fragment.VideosFragment;

public class LandingActivity extends AppCompatActivity {

    private Activity activity;

    private Toolbar toolbar;

    private TabLayout tabLayout;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_landing);

        activity = this;

        initUI();

    }

    private void initUI() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setUpViewPager(ViewPager viewPager) {

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(new PhotosFragment(), activity.getResources().getString(R.string.photos));
        pagerAdapter.addFragment(new VideosFragment(), activity.getResources().getString(R.string.videos));
        pagerAdapter.addFragment(new GifsFragment(), activity.getResources().getString(R.string.gifs));

        viewPager.setAdapter(pagerAdapter);

    }
}
