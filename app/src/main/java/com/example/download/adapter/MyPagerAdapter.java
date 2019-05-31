package com.example.download.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
//自定义pagerview的适配器MyPagerAdapter
public class MyPagerAdapter extends PagerAdapter {
    private ArrayList<View> viewLists;
    public MyPagerAdapter(ArrayList<View> viewLists)
    {
        this.viewLists = viewLists;
    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }
    @Override
    public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }
}
