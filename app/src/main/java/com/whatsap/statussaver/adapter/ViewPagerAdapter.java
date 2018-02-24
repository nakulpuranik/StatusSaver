package com.whatsap.statussaver.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swanand Deshpande on 24/2/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentList = new ArrayList<>();

    private final ArrayList<String> fragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    public void addFragment(Fragment fragment, String title) {

        fragmentList.add(fragment);

        fragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
