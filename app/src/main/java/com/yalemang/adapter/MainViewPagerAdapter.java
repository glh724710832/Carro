package com.yalemang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * @author Administrator
 */
public class MainViewPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<View> viewArrayList;

    public MainViewPagerAdapter(Context context, ArrayList<View> viewArrayList) {
        this.context = context;
        this.viewArrayList = viewArrayList;
    }

    @Override
    public int getCount() {
        return viewArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewArrayList.get(position));
        return viewArrayList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(viewArrayList.get(position));
    }
}
