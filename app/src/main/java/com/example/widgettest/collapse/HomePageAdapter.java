package com.example.widgettest.collapse;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hesh on 2018/4/24.
 */

public class HomePageAdapter extends FragmentPagerAdapter {

    private Context context;

    private String[] pages=new String[]{"java","kotlin","c++","python"};

    public HomePageAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return pages.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pages[position];
    }
}
