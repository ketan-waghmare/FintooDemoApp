package com.coc.fintoodemoapp.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.coc.fintoodemoapp.fragments.FourFragment;
import com.coc.fintoodemoapp.fragments.OneFragment;
import com.coc.fintoodemoapp.fragments.ThreeFragment;
import com.coc.fintoodemoapp.fragments.TwoFragment;

/**
 * Created by ketan on 11-10-2018.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final String[] tabTitles = new String[]{"Personal", "Medical", "LifeStyle"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {

            case 0:
                return OneFragment.newInstance("","");
            case 1:
                return TwoFragment.newInstance("","");
            case 2:
                return ThreeFragment.newInstance("","");
            case 3:
                return FourFragment.newInstance("","");
            default:
                return OneFragment.newInstance("","");
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}