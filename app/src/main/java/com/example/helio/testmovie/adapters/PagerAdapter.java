package com.example.helio.testmovie.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.helio.testmovie.ui.fragment.FavoriteFragment;
import com.example.helio.testmovie.ui.fragment.SearchFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SearchFragment searchFragment = new SearchFragment();
                return searchFragment;
            case 1:
                FavoriteFragment favoriteFragment = new FavoriteFragment();
                return favoriteFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
