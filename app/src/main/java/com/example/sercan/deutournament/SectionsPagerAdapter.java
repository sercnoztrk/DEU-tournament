package com.example.sercan.deutournament;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;
    ArrayList<String> listPerRound[] /* tabName */;

    public SectionsPagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<String> listPerRound[]) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.listPerRound = listPerRound;
    }

    @Override
    public Fragment getItem(int position) {
        FragmentB comn = new FragmentB();
        return comn.newInstance(listPerRound[position]);
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
