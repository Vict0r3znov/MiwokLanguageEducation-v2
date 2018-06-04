package com.exemple.android.miwoklanguageeducation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int mNumberOfTabs;

    public PagerAdapter (FragmentManager fm, int numberOfTabs){
        super(fm);
        mNumberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0 : return new NumbersFragment();
            case 1 : return new FamilyFragment();
            case 2 : return new ColorsFragment();
            case 3 : return new PhrasesFragment();
            default:
            return null;
        }
    }

    @Override
    public int getCount(){
        return mNumberOfTabs;
    }
}
